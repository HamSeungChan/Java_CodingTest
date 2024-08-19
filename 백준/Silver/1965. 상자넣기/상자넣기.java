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
        array = new int[n];
        dp = new int[1001][1001];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        System.out.println(recursion(0, 0));
    }

    public static int recursion(int index, int before) {

        if (dp[index][before] != -1) {
            return dp[index][before];
        }

        if (index == n) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE;

        // 선택함
        if (before < array[index]) {
            maxValue = Math.max(maxValue, recursion(index + 1, array[index]) + 1);
        }
        // 선택하지 않음
        maxValue = Math.max(maxValue, recursion(index + 1, before));

        return dp[index][before] = maxValue;
    }
}