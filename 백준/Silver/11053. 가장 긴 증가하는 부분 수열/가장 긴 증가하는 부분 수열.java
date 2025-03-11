import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        dp = new int[n + 1][1001];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        System.out.println(recursion(0, 0));
    }

    public static int recursion(int index, int beforeBest) {

        if (dp[index][beforeBest] != 0) {
            return dp[index][beforeBest];
        }

        if (index == n) {
            return 0;
        }

        int max = 0;

        // pick O
        if (beforeBest < array[index]) {
            max = Math.max(max, recursion(index + 1, array[index]) + 1);
        }

        // pick X
        max = Math.max(max, recursion(index + 1, beforeBest));

        return dp[index][beforeBest] = max;
    }
}
