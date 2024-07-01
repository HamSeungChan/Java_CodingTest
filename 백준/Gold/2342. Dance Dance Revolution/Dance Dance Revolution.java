import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static int[][][] dp = new int[100001][5][5];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        array = new int[token.countTokens()];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(recursion(0, 0, 0));
    }

    public static int recursion(int left, int right, int index) {


        if (dp[index][left][right] != -1) {
            return dp[index][left][right];
        }

        if (index == array.length - 1) {
            return 0;
        }

        int tmp = array[index];


        if (left == tmp || right == tmp) {
            return dp[index][left][right] = recursion(left, right, index + 1) + 1;
        }

        // 왼발
        int minValue = Integer.MAX_VALUE;
        if (left == 0) {
            minValue = Math.min(minValue, recursion(tmp, right, index + 1) + 2);
        } else if (Math.abs(tmp - left) == 2) {
            minValue = Math.min(minValue, recursion(tmp, right, index + 1) + 4);
        } else {
            minValue = Math.min(minValue, recursion(tmp, right, index + 1) + 3);
        }

        // 오른발
        if (right == 0) {
            minValue = Math.min(minValue, recursion(left, tmp, index + 1) + 2);
        } else if (Math.abs(tmp - right) == 2) {
            minValue = Math.min(minValue, recursion(left, tmp, index + 1) + 4);
        } else {
            minValue = Math.min(minValue, recursion(left, tmp, index + 1) + 3);
        }

        return dp[index][left][right] = minValue;
    }
}