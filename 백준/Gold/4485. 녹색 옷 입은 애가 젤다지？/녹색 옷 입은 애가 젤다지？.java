import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static int n;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        int count = 1;
        while (true) {

            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            array = new int[n][n];
            for (int i = 0; i < n; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    array[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            sb.append("Problem ").append(count).append(": ").append(bfs()).append("\n");
            count++;
        }
        System.out.println(sb);
    }


    public static int bfs() {
        int answer = 0;
        int[][] check = new int[n][n];
        for(int i = 0; i < check.length; i++){
            Arrays.fill(check[i], 100_000_000);
        }
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        check[0][0] = array[0][0];

        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < MOVE_X.length; i++) {
                int moveX = tmp.x + MOVE_X[i];
                int moveY = tmp.y + MOVE_Y[i];
                if (isRange(moveX, moveY) && check[moveX][moveY] > check[tmp.x][tmp.y] + array[moveX][moveY]) {
                    check[moveX][moveY] = check[tmp.x][tmp.y] + array[moveX][moveY];
                    q.offer(new Point(moveX, moveY));
                }
            }
        }

        return check[n-1][n-1];
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