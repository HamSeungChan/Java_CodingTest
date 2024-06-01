import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n + 1][4];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recursion(0, 0));
    }

    public static int recursion(int index, int beforeDrink) {

        if (dp[index][beforeDrink] != -1) {
            return dp[index][beforeDrink];
        }

        if (beforeDrink == 3) {
            return -10000000;
        }

        if (index == n) {
            return 0;
        }

        int tmp = Integer.MIN_VALUE;

        // 마셨음
        tmp = Math.max(tmp, recursion(index + 1, beforeDrink + 1) + array[index]);

        // 마시지 않음
        tmp = Math.max(tmp, recursion(index + 1, 0));

        return dp[index][beforeDrink] = tmp;
    }

}