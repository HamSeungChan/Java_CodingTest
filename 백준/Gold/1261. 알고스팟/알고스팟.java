import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map, check;
    static int n, m;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        check = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(check[i], Integer.MAX_VALUE);
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));
        check[0][0] = 0;

        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = tmp.x + MOVE_X[i];
                int moveY = tmp.y + MOVE_Y[i];
                if (canMove(moveX, moveY)) {
                    int newValue = tmp.count + map[moveX][moveY];
                    if (check[moveX][moveY] > newValue) {
                        check[moveX][moveY] = newValue;
                        q.offer(new Point(moveX, moveY, newValue));
                    }
                }
            }
        }

        System.out.println(check[n - 1][m - 1]);
    }


    public static boolean canMove(int moveX, int moveY) {
        return 0 <= moveX && moveX < n && 0 <= moveY && moveY < m;
    }
}

class Point {
    int x;
    int y;
    int count;

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}