import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[][] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recursion(1, 1));
    }

    public static long recursion(int x, int y) {

        if (x > n || y > m) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == n && y == m) {
            return 1;
        }

        dp[x][y] = recursion(x + 1, y) % 1000000007 + recursion(x, y + 1) % 1000000007
                + recursion(x + 1, y + 1) % 1000000007;
        return dp[x][y] % 1000000007;
    }
}