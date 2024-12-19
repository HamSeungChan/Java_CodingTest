import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(recursion(n) + 1);
    }

    public static int recursion(int value) {

        if (dp[value] != -1) {
            return dp[value];
        }

        if (value < 2) {
            return 0;
        }

        return dp[value] = (recursion(value - 2) + recursion(value - 1) + 2) % 1000000007;
    }
}