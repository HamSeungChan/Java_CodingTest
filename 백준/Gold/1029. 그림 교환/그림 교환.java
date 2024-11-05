import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[][] array;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                array[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }

        dp = new int[1 << (n + 1)][n + 1][10];
        for (int i = 0; i < 1 << (n + 1); i++) {
            for (int j = 0; j < n + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(recursion(1 << 1, 1, 0) + 1);
    }

    public static int recursion(int bit, int before, int beforeMoney) {

        if (dp[bit][before][beforeMoney] != -1) {
            return dp[bit][before][beforeMoney];
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {

            int newValue = bit | (1 << i);
            if (newValue == bit) {
                continue;
            }

            if (beforeMoney > array[before][i]) {
                continue;
            }

            max = Math.max(max, recursion(newValue, i, array[before][i]) + 1);
        }

        return dp[bit][before][beforeMoney] = max;
    }
}