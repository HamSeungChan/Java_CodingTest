import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        dp = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                int value = Integer.parseInt(token.nextToken());
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + (value == 0 ? 0 : 1) - dp[i - 1][j - 1];
            }
        }

        int lt = 0;
        int rt = Math.min(n, m);

        int answer = 0;
        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            if (solution(mid)) {
                answer = mid;
                lt = mid + 1;
                continue;
            }
            rt = mid - 1;
        }

        System.out.println(answer);

    }

    public static boolean solution(int mid) {
        for (int i = mid; i <= n; i++) {
            for (int j = mid; j <= m; j++) {
                int result = dp[i][j] - dp[i - mid][j] - dp[i][j - mid] + dp[i - mid][j - mid];
                if (result == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
