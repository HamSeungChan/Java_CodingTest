import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] array, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n][2];
        dp = new int[1001][1001];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        Arrays.sort(array, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(recursion(0, 0));
    }


    public static int recursion(int day, int index) {

        if (dp[day][index] != -1) {
            return dp[day][index];
        }

        if (index == n) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE;

        // 선택
        if (day < array[index][0]) {
            maxValue = Math.max(maxValue, recursion(day + 1, index + 1) + array[index][1]);
        }
        // 안선택
        maxValue = Math.max(maxValue, recursion(day, index + 1));

        return dp[day][index] = maxValue;
    }
}