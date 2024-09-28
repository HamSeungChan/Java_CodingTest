import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(recursion(1, m - array[0]));
    }

    public static int recursion(int index, int leftSpace) {

        if (dp[index][leftSpace] != -1) {
            return dp[index][leftSpace];
        }

        if (index == n) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        // 다음 줄에 쓴다.
        min = Math.min(min, recursion(index + 1, m - array[index]) + leftSpace * leftSpace);

        // 다음 줄에 쓰지 않는다.
        if (leftSpace - 1 >= array[index]) {
            min = Math.min(min, recursion(index + 1, leftSpace - 1 - array[index]));
        }

        return dp[index][leftSpace] = min;
    }
}