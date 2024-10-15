import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, total;
    static int[] array;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
            total += array[i];
        }

        dp = new int[n + 1][2501][2501];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 2501; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(recursion(0, 0, 0));
    }

    public static int recursion(int index, int first, int second) {

        if (dp[index][first][second] != -1) {
            return dp[index][first][second];
        }

        if (index == n) {
            int third = total - first - second;
            if (first >= second && second >= third) {
                return third;
            }
            return -1000000;
        }

        int tmp = 0;

        // 첫째가 먹는 경우
        tmp = Math.max(tmp, recursion(index + 1, first + array[index], second));

        // 둘째가 먹는 경우
        tmp = Math.max(tmp, recursion(index + 1, first, second + array[index]));

        // 셋째가 먹는 경우
        tmp = Math.max(tmp, recursion(index + 1, first, second));


        return dp[index][first][second] = tmp;
    }
}