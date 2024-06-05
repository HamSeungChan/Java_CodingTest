import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        long k = Long.parseLong(token.nextToken());

        long[] dp = new long[n + 1];

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        long answer = 0;

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(token.nextToken());
            if (map.containsKey(dp[i] - k)) {
                answer += map.get(dp[i] - k);
            }
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }
        System.out.println(answer);
    }
}