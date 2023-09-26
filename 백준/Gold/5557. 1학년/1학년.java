import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        // 0 ~ 20 까지의 수를 저장.
        long[][] dp = new long[n - 1][21];
        // 처음 들어온 수는 무조건 0 이다.
        dp[0][array[0]] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int sum = 0; sum <= 20; sum++) {
                // 전 값에서 더하기
                if (sum - array[i] >= 0) {
                    dp[i][sum] += dp[i - 1][sum - array[i]];
                }
                // 전 값에서 빼기
                if (sum + array[i] <= 20) {
                    dp[i][sum] += dp[i - 1][sum + array[i]];
                }
            }
        }
        System.out.println(dp[n - 2][array[n - 1]]);
    }
}