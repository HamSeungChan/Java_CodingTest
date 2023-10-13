import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        dp = new long[18][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = i + dp[1][i - 1];
        }
        long id = 10;
        for (int i = 2; i <= 17; i++) {

            for (int k = 0; k <= 9; k++) {
                if (k == 0) {
                    dp[i][k] = dp[i - 1][9];
                } else {
                    dp[i][k] = dp[i][k - 1] + (long) k * id + dp[i - 1][9];
                }
            }
            id *= 10;
        }

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            long l = Long.parseLong(token.nextToken());
            long u = Long.parseLong(token.nextToken());


            sb.append("#").append(t).append(" ");
            if (l == 0) {
                sb.append(getValue(u)).append("\n");
            } else {
                sb.append(getValue(u) - getValue(l - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }


    public static long getValue(long n) {

        int size = size(n);
        long div = div(size);

        if (n == 0) {
            return 0;
        }

        if (size == 1) {
            return dp[size][(int) n];
        }

        long firstValue = n / div;
//        System.out.println(div)
        return dp[size][(int) (firstValue - 1)] + firstValue * ((n % div) + 1) + getValue(n % div);
    }

    public static long div(long size) {
        long div = 1;
        for (int i = 1; i < size; i++) {
            div *= 10;
        }
        return div;
    }

    public static int size(long n) {
        String s = String.valueOf(n);
        return s.length();
    }

}