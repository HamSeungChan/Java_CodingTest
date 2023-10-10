import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int[][] array;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(s[j]);
                if (tmp == 1) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1;
                }
            }
        }

        int[][] value = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(value[i], Integer.MAX_VALUE);
        }
        bfs(value);
        System.out.println(value[n - 1][n - 1]);
    }

    public static void bfs(int[][] value) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        value[0][0] = 0;
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < MOVE_X.length; i++) {
                int moveX = tmp.x + MOVE_X[i];
                int moveY = tmp.y + MOVE_Y[i];
                if (isRange(moveX, moveY)) {
                    if (value[moveX][moveY] > value[tmp.x][tmp.y] + array[moveX][moveY]) {
                        value[moveX][moveY] = value[tmp.x][tmp.y] + array[moveX][moveY];
                        q.offer(new Point(moveX, moveY));
                    }
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
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