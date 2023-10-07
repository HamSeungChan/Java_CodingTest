import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] check;
    static int n, m;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        map = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            map[x][y] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] > 0 && !check[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        check[x][y] = true;
        Point start = new Point(x, y);
        q.offer(start);

        int count = 1;
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < MOVE_X.length; i++) {
                int moveX = tmp.x + MOVE_X[i];
                int moveY = tmp.y + MOVE_Y[i];
                if (canMerge(moveX, moveY)) {
                    Point mergerPoint = new Point(moveX, moveY);
                    q.offer(mergerPoint);
                    check[moveX][moveY] = true;
                    count++;
                }
            }
        }

        answer = Math.max(answer, count);

    }

    public static boolean canMerge(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= m && !check[x][y] && map[x][y] > 0;
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