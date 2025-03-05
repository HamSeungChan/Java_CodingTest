import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<List<Integer>> map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 2][n + 1];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        StringTokenizer token;
        for (int i = 1; i <= n; i++) {
            List<Integer> now = map.get(i);
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i; j++) {
                now.add(Integer.parseInt(token.nextToken()));
            }
        }

        System.out.println(recursion(2, 0) + map.get(1).get(0));
    }

    public static int recursion(int height, int beforeIndex) {

        if (dp[height][beforeIndex] != -1) {
            return dp[height][beforeIndex];
        }

        if (height == n + 1) {
            return 0;
        }

        List<Integer> now = map.get(height);
        return dp[height][beforeIndex] =
                Math.max(recursion(height + 1, beforeIndex) + now.get(beforeIndex),
                        recursion(height + 1, beforeIndex + 1) + now.get(beforeIndex + 1));
    }
}
