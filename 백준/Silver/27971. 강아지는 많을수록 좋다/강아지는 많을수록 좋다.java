import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, a, b, answer = Integer.MAX_VALUE;
    static boolean[] close;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        a = Integer.parseInt(token.nextToken());
        b = Integer.parseInt(token.nextToken());

        close = new boolean[n + 1];
        dp = new int[n + 1];

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            for (int j = start; j <= end; j++) {
                close[j] = true;
            }
        }


        Arrays.fill(dp, -1);

        answer = recursion(0);
        System.out.println(answer >= 100000000 ? -1 : answer);
    }

    public static int recursion(int puppyCount) {

        // 강아지의 수가 더 많은 경우
        if (puppyCount > n) {
            return 100000000;
        }

        if (dp[puppyCount] != -1) {
            return dp[puppyCount];
        }

        // 닫힌 구간에 포함되는 경우
        if (close[puppyCount]) {
            return dp[puppyCount] = 100000000;
        }

        if (puppyCount == n) {
            return 0;
        }

        return dp[puppyCount] = Math.min(recursion(puppyCount + a) + 1,
                recursion(puppyCount + b) + 1);
    }
}