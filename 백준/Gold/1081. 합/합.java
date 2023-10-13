import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        long l = Integer.parseInt(token.nextToken());
        long u = Integer.parseInt(token.nextToken());

        int count = size(u);
        dp = new long[count + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = i + dp[1][i - 1];
        }
        long id = 10;
        for (int i = 2; i <= count; i++) {

            for (int k = 0; k <= 9; k++) {
                if (k == 0) {
                    dp[i][k] = dp[i - 1][9];
                } else {
                    dp[i][k] = dp[i][k - 1] + (long)k * id + dp[i - 1][9];
                }
            }
            id *= 10;
        }


//        System.out.println(getValue(u) - getValue(l - 1));
//        System.out.println(getValue(u));
//        System.out.println(getValue(l - 1));
        if(l == 0){
            System.out.println(getValue(u) - 0);
        }
        else{
            System.out.println(getValue(u) - getValue(l - 1));
        }

//        System.out.println(getValue(u));
//        System.out.println(getValue(l-1));
//        System.out.println(getValue(2000));
    }

    public static long getValue(long n) {

        int size = size(n);
        long div = div(size);

        if(n == 0){
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
        int div = 1;
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