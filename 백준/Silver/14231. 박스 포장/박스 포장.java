import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n + 1];
        dp = new int[n + 2][n + 2];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recursion(1, 0));
    }

    public static int recursion(int index, int lastIndex) {

        if (dp[index][lastIndex] != -1) {
            return dp[index][lastIndex];
        }

        if (index == n + 1) {
            return 0;
        }

        int max = 0;

        if (array[lastIndex] < array[index]) {
            max = Math.max(max, recursion(index + 1, index) + 1);
        }

        return dp[index][lastIndex] = Math.max(max, recursion(index + 1, lastIndex));
    }
}