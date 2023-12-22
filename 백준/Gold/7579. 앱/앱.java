import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        // 활성화 되어 있는 앱들
        int n = Integer.parseInt(token.nextToken());
        // 필요한 메모리
        int m = Integer.parseInt(token.nextToken());

        // 메모리 입력
        int[] memory = new int[n + 1];
        int totalMemory = 0;
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(token.nextToken());
            totalMemory += memory[i];
        }

        // 비용
        int[] cost = new int[n + 1];
        int totalCost = 0;
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(token.nextToken());
            totalCost += cost[i];
        }


        int[][] dp = new int[n + 1][totalCost + 1];
        Arrays.fill(dp[0], 0);
        int answer = Integer.MAX_VALUE;

        // 앱 하나씩
        for (int i = 1; i <= n; i++) {
            // 무게증가
            for (int j = 0; j <= totalCost; j++) {
                if (j < cost[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
                }

                if (dp[i][j] >= m) {
                    answer = Math.min(answer, j);
                }

            }
        }
        System.out.println(answer);
    }
}