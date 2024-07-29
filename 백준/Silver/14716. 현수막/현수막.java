import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] check;
    static int[] MOVE_X = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] MOVE_Y = {0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        map = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j] && map[i][j] == 1) {
                    bfs(new Point(i,j));
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void bfs(Point start) {

        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        check[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < MOVE_X.length; i++) {
                int moveX = now.x + MOVE_X[i];
                int moveY = now.y + MOVE_Y[i];
                if (canMove(moveX, moveY)) {
                    check[moveX][moveY] = true;
                    q.offer(new Point(moveX, moveY));
                }
            }
        }

    }

    public static boolean canMove(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && !check[x][y] && map[x][y] == 1;
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