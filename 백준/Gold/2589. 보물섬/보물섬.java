import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());


        array = new int[n][m];
       

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (tmp[j] == 'W') {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(array[i][j] == 0) {
                    answer = Math.max(answer, bfs(new Point(i,j)));
                }
            }
        }

        System.out.println(answer);
    }
    static int bfs(Point p) {
    	boolean[][] check = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        check[p.x][p.y] = true;

        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < MOVE_X.length; j++) {
                    int moveX = tmp.x + MOVE_X[j];
                    int moveY = tmp.y + MOVE_Y[j];
                    if (isValid(moveX, moveY,check)) {
                        check[moveX][moveY] = true;
                        q.offer(new Point(moveX, moveY));
                    }
                }
            }
            distance++;
        }
        return distance-1;
    }
    public static boolean isValid(int x, int y, boolean [][] check) {
        return x >= 0 && x < n && y >= 0 && y < m && array[x][y] == 0 && !check[x][y];
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