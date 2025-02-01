import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] array;
    static int[] MOVE_Y = {1, 0, -1};
    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        array = new int[n][m];
        dp = new int[n][m][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            minValue = Math.min(minValue, recursion(0, i, 3) + array[0][i]);
        }

        System.out.println(minValue);
    }

    public static int recursion(int x, int y, int beforeMove) {

        if (dp[x][y][beforeMove] != -1) {
            return dp[x][y][beforeMove];
        }

        // 달에 도착했을 때
        if (x == n - 1) {
            return 0;
        }

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < MOVE_Y.length; i++) {

            if (beforeMove == i) {
                continue;
            }

            int moveX = x + 1;
            int moveY = y + MOVE_Y[i];

            if (checkRange(moveY)) {
                minValue = Math.min(minValue, recursion(moveX, moveY, i) + array[moveX][moveY]);
            }
        }

        return minValue;
    }

    public static boolean checkRange(int y) {
        return 0 <= y && y < m;
    }

}