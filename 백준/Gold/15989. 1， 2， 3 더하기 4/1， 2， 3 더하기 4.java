import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {

            int value = Integer.parseInt(br.readLine());

            int[][] dp = new int[4][10001];
            dp[1][1] = 1;
            dp[2][2] = 1;
            dp[3][3] = 1;

            for (int j = 1; j <= 3; j++) {

                for (int k = 1; k <= value; k++) {
                    if (j <= k) {
                        dp[j][k] += dp[j][k - j] + dp[j - 1][k];
                    } else {
                        dp[j][k] = dp[j - 1][k];
                    }
                }
            }
            sb.append(dp[3][value]).append("\n");
        }
        System.out.print(sb);
    }
}