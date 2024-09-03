import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] MOVE_X = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] MOVE_Y = {0, 1, 0, -1, 1, -1, 1, -1};
    static int r, c;
    static int[][] map, dp, answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        map = new int[r][c];
        dp = new int[r][c];
        answer = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < r; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int result = recursion(i, j);
                int x = result / c;
                int y = result - x * c;
                answer[x][y] += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static int recursion(int x, int y) {

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int nextX = -1;
        int nextY = -1;
        int value = Integer.MAX_VALUE;

        for (int i = 0; i < MOVE_X.length; i++) {
            int moveX = x + MOVE_X[i];
            int moveY = y + MOVE_Y[i];

            // 우선 r,c 범위만 확인한다
            if (canMove(moveX, moveY)) {
                if (map[x][y] > map[moveX][moveY] && value > map[moveX][moveY]) {
                    nextX = moveX;
                    nextY = moveY;
                    value = map[moveX][moveY];
                }
            }
        }

        return dp[x][y] = (value != Integer.MAX_VALUE ? recursion(nextX, nextY) : x * c + y);
    }

    public static boolean canMove(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }
}