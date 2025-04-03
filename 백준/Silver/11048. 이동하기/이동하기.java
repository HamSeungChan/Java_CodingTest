import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] array;
    static int[] MOVE_X = {1, 0, 1};
    static int[] MOVE_Y = {0, 1, 1};
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        System.out.println(recursion(0, 0) + array[0][0]);
    }

    public static int recursion(int x, int y) {

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == n - 1 && y == m - 1) {
            return 0;
        }


        int max = 0;
        for (int i = 0; i < 3; i++) {
            int moveX = x + MOVE_X[i];
            int moveY = y + MOVE_Y[i];

            if (inRange(moveX, moveY)) {
                max = Math.max(max, recursion(moveX, moveY) + array[moveX][moveY]);
            }
        }

        return dp[x][y] = max;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
