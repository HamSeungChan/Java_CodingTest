import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int t, w, max = 0;
    static int[] array;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        t = Integer.parseInt(token.nextToken());
        w = Integer.parseInt(token.nextToken());

        array = new int[t];
        for (int i = 0; i < t; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[t + 1][w + 1][3];
        for (int i = 0; i < t + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(recursion(0, 0, 1));
    }

    public static int recursion(int index, int moveCount, int now) {

        if (dp[index][moveCount][now] != -1) {
            return dp[index][moveCount][now];
        }

        if (index == t) {
            return 0;
        }

        int max = 0;
        // 움직인다
        if (moveCount < w) {

            int newNow = now == 1 ? 2 : 1;
            max = Math.max(recursion(index + 1, moveCount + 1,
                    newNow) + (array[index] == newNow ? 1 : 0), max);
        }

        // 움직이지 않는다
        max = Math.max(max, recursion(index + 1, moveCount,
                now) + (array[index] == now ? 1 : 0));

        return dp[index][moveCount][now] = max;
    }
}