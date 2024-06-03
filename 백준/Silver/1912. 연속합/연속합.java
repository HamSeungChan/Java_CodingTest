import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < n + 1; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}