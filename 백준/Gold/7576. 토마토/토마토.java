import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] check;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());


        Queue<Point> q = new LinkedList<>();
        map = new int[n][m];
        check = new int[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new Point(i, j));
                    check[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = tmp.x + MOVE_X[i];
                int moveY = tmp.y + MOVE_Y[i];
                if (canMove(moveX, moveY)) {
                    check[moveX][moveY] = check[tmp.x][tmp.y] + 1;
                    map[moveX][moveY] = 1;
                    q.offer(new Point(moveX, moveY));
                }
            }
        }

        int answer = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 아직 토마토가 남은 경우
                if (map[i][j] == 0) {
                    flag = true;
                }
                answer = Math.max(answer, check[i][j]);
            }
        }
        System.out.println(!flag ? answer : -1);
    }

    public static boolean canMove(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && map[x][y] == 0;
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