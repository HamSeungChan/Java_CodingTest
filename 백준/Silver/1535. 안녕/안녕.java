import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, answer = 0;
    static int[] health, happy;
    static int[][] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        health = new int[n];
        happy = new int[n];
        dp = new int[n + 1][101];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            health[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            happy[i] = Integer.parseInt(token.nextToken());
        }

        System.out.println(recursion(0, 100));
    }

    public static int recursion(int index, int totalHealth) {


        if (totalHealth <= 0) {
            return  -1999999999;
        }

        if (dp[index][totalHealth] != -1) {
            return dp[index][totalHealth];
        }

        if (index == n) {
            return 0;
        }

        return dp[index][totalHealth] = Math.max(recursion(index + 1, totalHealth - health[index]) + happy[index],
                recursion(index + 1, totalHealth));
    }
}