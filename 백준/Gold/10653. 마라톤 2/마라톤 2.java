import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[][] point;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        point = new int[n][2];
        dp = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                point[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        System.out.println(recursion(1, 0, 0));
    }

    public static int recursion(int index, int now, int jumpCount) {

        if (dp[index][now][jumpCount] != -1) {
            return dp[index][now][jumpCount];
        }

        if (index == n - 1) {
            return dp[index][now][jumpCount] = move(now, index);
        }

        int minValue = Integer.MAX_VALUE;

        // jump 하는 경우
        if (jumpCount < k) {
            minValue = Math.min(minValue, recursion(index + 1, now, jumpCount + 1));
        }

        // jump 하지 않는 경우
        minValue = Math.min(minValue, recursion(index + 1, index, jumpCount) + move(now, index));

        return dp[index][now][jumpCount] = minValue;
    }

    public static int move(int now, int next) {

        return Math.abs(point[now][0] - point[next][0]) + Math.abs(point[now][1] - point[next][1]);
    }


}