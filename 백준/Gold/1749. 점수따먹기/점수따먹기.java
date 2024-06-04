import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                int value = Integer.parseInt(token.nextToken());
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + value;
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = i; k <= n; k++) {
                    for (int l = j; l <= m; l++) {
                        answer = Math.max(answer, dp[k][l] - dp[k - i][l] - dp[k][l - j] + dp[k - i][l - j]);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}