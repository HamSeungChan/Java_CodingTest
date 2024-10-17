import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] array, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        // 남은 기간 일
        n = Integer.parseInt(token.nextToken());
        // 챕터의 수
        m = Integer.parseInt(token.nextToken());

        dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        array = new int[m][2];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        System.out.println(recursion(0,0));
    }

    public static int recursion(int index, int day) {

        if (day > n) {
            return -1000000;
        }

        if (dp[index][day] != -1) {
            return dp[index][day];
        }

        if (index == m) {
            return 0;
        }

        int max = 0;

        // 챕터를 읽는다.
        max = Math.max(max, recursion(index + 1, day + array[index][0]) + array[index][1]);

        // 챕터를 읽지 않는다.
        max = Math.max(max, recursion(index + 1, day));

        return dp[index][day] = max;
    }
}