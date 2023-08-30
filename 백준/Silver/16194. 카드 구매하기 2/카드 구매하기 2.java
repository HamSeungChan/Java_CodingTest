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
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int minValue = array[i];
            int startIndex = 1;
            int endIndex = i - 1;
            while (startIndex <= endIndex) {
                minValue = Math.min(minValue, dp[startIndex] + dp[endIndex]);
                startIndex++;
                endIndex--;
            }
            dp[i] = minValue;
        }

        System.out.println(dp[n]);


    }
}