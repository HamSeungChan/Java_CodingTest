import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static int n, m;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());
        array = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                array[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        int[][] value = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(value[i], 100_000_000);
        }

        if (n == 1 && m == 1) {
            System.out.println(0);
        } else {
            bfs(value);
            System.out.println(value[n][m]);
        }

    }

    public static void bfs(int[][] value) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(1, 1));
        value[1][1] = 0;
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < MOVE_X.length; i++) {
                int moveX = tmp.x + MOVE_X[i];
                int moveY = tmp.y + MOVE_Y[i];
                if (range(moveX, moveY) && value[moveX][moveY] > value[tmp.x][tmp.y] + array[moveX][moveY]) {
                    q.offer(new Point(moveX, moveY));
                    value[moveX][moveY] = value[tmp.x][tmp.y] + array[moveX][moveY];
                }
            }
        }
    }

    public static boolean range(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= m;
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