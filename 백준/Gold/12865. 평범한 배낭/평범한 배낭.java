import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[][] dp = new int[n + 1][k + 1];

        Arrays.fill(dp[0], 0);

        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());

            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}