import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        dp = new int[10000000];
        Arrays.fill(dp, -1);

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        System.out.println(recursion(0));
    }

    public static int recursion(int time) {

        if (dp[time] != -1) {
            return dp[time];
        }

        if (time > n) {
            return 0;
        }

        if (time == n) {
            return 1;
        }

        dp[time] = recursion(time + 1) % 1000000007 + recursion(time + m) % 1000000007;
        return dp[time] % 1000000007;
    }
}