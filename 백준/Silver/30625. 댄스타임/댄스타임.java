import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, answer = 0;
    static int[][] dance;
    static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        dp = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }


        dance = new int[n][2];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                dance[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        System.out.println(recursion(0, 0));
    }

    public static long recursion(int index, int chance) {

        if (dp[index][chance] != -1) {
            return dp[index][chance];
        }

        if (index == n) {
            return 1;
        }

        long answer = 0;

        // 우진이가 앞을 보는 경우, 같은 춤을 춰야 한다, 0
        if (dance[index][1] == 0) {

            // 같은 춤을 추는 경우
            answer += recursion(index + 1, chance) % 1000000007;

            // 찬스를 쓰는 경우
            if (chance == 0) {
                for (int i = 0; i < m - 1; i++) {
                    answer += recursion(index + 1, chance + 1) % 1000000007;
                }
            }
        }

        // 우진이가 뒤를 보는 경우, 다른 춤을 춰야 한다, 1
        else {
            // 같은 춤을 추는 경우
            if (chance == 0) {
                answer += recursion(index + 1, chance + 1) % 1000000007;
            }

            // 다른 춤을 추는 경우
            for (int i = 0; i < m - 1; i++) {
                answer += recursion(index + 1, chance) % 1000000007;
            }
        }

        return dp[index][chance] = answer % 1000000007;
    }
}