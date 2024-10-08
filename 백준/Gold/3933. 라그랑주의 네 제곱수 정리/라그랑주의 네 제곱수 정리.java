import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int findValue;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new int[5][182][32769];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 182; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        while (true) {
            findValue = Integer.parseInt(br.readLine());
            if (findValue == 0) {
                break;
            }
            sb.append(recursion(0, 1, findValue)).append("\n");
        }

        System.out.print(sb);
    }

    public static int recursion(int index, int before, int value) {

        if (dp[index][before][value] != -1) {
            return dp[index][before][value];
        }


        if (value == 0) {
            return dp[index][before][value] = 1;
        }

        if (index == 4) {
            return dp[index][before][value] = 0;
        }


        int count = 0;
        for (int i = before; i <= Math.sqrt(value); i++) {
            count += recursion(index + 1, i, value - i * i);
        }


        return dp[index][before][value] = count;
    }
}