import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int c, n;
    static int[][] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        c = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());
        dp = new int[3000];

        Arrays.fill(dp, -1);

        array = new int[n][2];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        System.out.println(recursion(0));

    }

    public static int recursion(int now) {

        if (dp[now] != -1) {
            return dp[now];
        }

        if (now >= c) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, recursion(now + array[i][1]) + array[i][0]);
        }
        return dp[now] = minCost;
    }
}