import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int[] array = new int[3];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        dp = new int[61][61][61];
        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(recursion(array[0], array[1], array[2]));
    }

    public static int recursion(int a, int b, int c) {

        if (dp[a][b][c] != -1) {
            return dp[a][b][c];
        }

        if (a <= 0 && b <= 0 && c <= 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        // a b c
        min = Math.min(min, recursion(Math.max(a - 9, 0), Math.max(b - 3, 0), Math.max(c - 1, 0)) + 1);

        // a c b
        min = Math.min(min, recursion(Math.max(a - 9, 0), Math.max(c - 3, 0), Math.max(b - 1, 0)) + 1);


        // b a c
        min = Math.min(min, recursion(Math.max(b - 9, 0), Math.max(a - 3, 0), Math.max(c - 1, 0)) + 1);


        // b c a
        min = Math.min(min, recursion(Math.max(b - 9, 0), Math.max(c - 3, 0), Math.max(a - 1, 0)) + 1);


        // c a b
        min = Math.min(min, recursion(Math.max(c - 9, 0), Math.max(a - 3, 0), Math.max(b - 1, 0)) + 1);


        // c b a
        min = Math.min(min, recursion(Math.max(c - 9, 0), Math.max(b - 3, 0), Math.max(a - 1, 0)) + 1);

        return dp[a][b][c] = min;
    }
}