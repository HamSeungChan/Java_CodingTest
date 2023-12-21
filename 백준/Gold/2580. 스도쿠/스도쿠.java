import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[9][9];
    static List<Point> list = new ArrayList<>();
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer token;
        for (int i = 0; i < 9; i++) {
            token = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 9; j++) {
                int tmp = Integer.parseInt(token.nextToken());
                map[i][j] = tmp;
                if (tmp == 0) {
                    list.add(new Point(i, j));
                }
            }
        }

        backTracking(0);
    }

    public static void backTracking(int index) {
        

        if (check) {
            return;
        }

        if (index == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            check = true;
        } else {
            for (int i = 1; i <= 9; i++) {
                Point tmp = list.get(index);
                if (check(tmp, i)) {
                    map[tmp.x][tmp.y] = i;
                    backTracking(index + 1);
                    map[tmp.x][tmp.y] = 0;
                }
            }
        }

    }


    public static boolean check(Point p, int value) {


        // 가로 세로 확인
        for (int i = 0; i < 9; i++) {
            if (map[p.x][i] == value) {
                return false;
            }

            if (map[i][p.y] == value) {
                return false;
            }
        }

        // 같은 그룹 확인
        int xRange = (p.x / 3) * 3;
        int yRange = (p.y / 3) * 3;
        for (int i = xRange; i < xRange + 3; i++) {
            for (int j = yRange; j < yRange + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}


class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}