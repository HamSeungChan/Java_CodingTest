import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];

            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(token.nextToken());
                dp[value] += 1;

                for (int j = value + 1; j <= m; j++) {
                    dp[j] += dp[j - value];
                }
            }
            sb.append(dp[m]).append("\n");
        }

        System.out.println(sb);
    }
}