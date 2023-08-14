import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static List<Point> chickenList = new ArrayList<>();
    static List<Point> houseList = new ArrayList<>();
    static int m;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        

        int[][] map = new int[n][n];


        for (int i = 0; i < n; i++) {
        	token = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(token.nextToken());
                map[i][j] = tmp;

                if (tmp == 2) {
                    chickenList.add(new Point(i, j));
                }

                if (tmp == 1) {
                    houseList.add(new Point(i, j));
                }
            }
        }

        selectChicken(0, 0, new int[m]);
        System.out.println(answer);
    }

    static void selectChicken(int start, int value, int[] select) {
        if (value == select.length) {
            int totalDistance = 0;
            for (Point house : houseList) {
                int minDistance = Integer.MAX_VALUE;
                for (int x : select) {
                    minDistance = Math.min(minDistance, Math.abs(house.x - chickenList.get(x).x) + Math.abs(house.y - chickenList.get(x).y));
                }
                totalDistance += minDistance;
            }
            answer = Math.min(totalDistance,answer);
        } else {
            for (int i = start; i < chickenList.size(); i++) {
                select[value] = i;
                selectChicken(i + 1, value + 1, select);
            }
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}