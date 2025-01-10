import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, t;
    static int[][] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        t = Integer.parseInt(token.nextToken());

        array = new int[n][2];

        dp = new int[n + 1][t + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        System.out.println(recursion(0, 0));

    }

    public static int recursion(int index, int time) {

        if (time > t) {
            return -10000000;
        }

        if (dp[index][time] != -1) {
            return dp[index][time];
        }

        if (index == n) {
            return 0;
        }


        return dp[index][time] = Math.max(recursion(index + 1, time + array[index][0]) + array[index][1],
                recursion(index + 1, time));
    }

}