import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCase; t++) {
            // 동전의 갯수
            int n = Integer.parseInt(br.readLine());
            // 동전 입력
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            // 만들고 싶은 금액
            int m = Integer.parseInt(br.readLine());

            int[][] dp = new int[n + 1][m + 1];
            // 코인이 없을 때 값 -> 0 으로
            Arrays.fill(dp[0], 0);

            // 코인의 갯수만큼 for문
            for (int i = 1; i <= n; i++) {
                int coin = Integer.parseInt(token.nextToken());
                // 만들고 싶은 금액까지
                for (int j = 0; j <= m; j++) {


                    // 금액보다 coin 값이 더 클 때
                    if (j < coin) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j == coin) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                    }

                }
            }

            sb.append(dp[n][m]).append("\n");

        }

        System.out.println(sb);

    }
}