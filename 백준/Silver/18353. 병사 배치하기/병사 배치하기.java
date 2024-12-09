import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n + 1];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        array[0] = 10000001;
        dp = new int[2002][2002];
        for (int i = 0; i < 2002; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(n - recursion(1, 0));
    }

    public static int recursion(int index, int before) {

        if (dp[index][before] != -1) {
            return dp[index][before];
        }

        if (index == n + 1) {
            return 0;
        }

        int max = 0;
        // 선수를 열외한다.
        max = Math.max(max, recursion(index + 1, before));
        // 선수를 열외하지 않는다.
        if (array[index] < array[before]) {
            max = Math.max(max, recursion(index + 1, index) + 1);
        }
        return dp[index][before] = max;
    }
}