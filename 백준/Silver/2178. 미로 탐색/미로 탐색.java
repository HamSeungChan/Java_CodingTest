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
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        map = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        Queue<Point> q = new LinkedList<>();
        check[0][0] = true;
        q.offer(new Point(0, 0));

        int answer = 0;
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Point tmp = q.poll();

                // 도착한 경우
                if (tmp.x == n - 1 && tmp.y == m - 1) {
                    answer = depth;
                }

                // 이동
                for (int i = 0; i < 4; i++) {
                    int moveX = tmp.x + MOVE_X[i];
                    int moveY = tmp.y + MOVE_Y[i];
                    if (canMove(moveX, moveY)) {
                        check[moveX][moveY] = true;
                        q.offer(new Point(moveX, moveY));
                    }
                }
            }
            depth++;
        }
        System.out.println(answer);
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