import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n, MOD = 1000000000;
    static int [][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][10][1 << 10];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j] , -1);
            }
        }

        int sum = 0;
        for (int i = 1; i <= 9 ; i++) {
            sum = (sum + recursion(1, i, 1 << i )) % MOD;
        }

        System.out.println(sum);
    }

    public static int recursion(int index, int before, int bit) {

        if(dp[index][before][bit] != -1){
            return dp[index][before][bit];
        }

        if (index == n) {
            return bit == (1 << 10) - 1 ?  1: 0;
        }

        int count = 0;

        if (before != 9) {
            count = (count +recursion(index + 1, before + 1, bit | 1 << (before + 1))) % MOD;
        }

        if(before != 0){
            count = (count + recursion(index + 1, before - 1, bit | 1 << (before - 1))) % MOD;
        }

        return dp[index][before][bit] = count;
    }
}