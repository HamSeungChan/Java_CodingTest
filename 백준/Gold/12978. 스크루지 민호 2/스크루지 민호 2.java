import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][2];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);

        }


        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer token;
        for (int i = 0; i < n - 1; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        System.out.println(Math.min(recursion(0, 1, 0) + 1, recursion(0, 1, 1)));
    }

    // isPolice 값이 0 이면 경찰서 O
    // isPolice 값이 1 이면 경찰서 X
    public static int recursion(int before, int now, int isPolice) {

        if (dp[now][isPolice] != -1) {
            return dp[now][isPolice];
        }

        int minValue = 0;

        List<Integer> nexts = graph.get(now);
        for (Integer next : nexts) {

            if (next == before) {
                continue;
            }

            // 전 구역이 경찰서가 아님
            if (isPolice == 1) {
                minValue += recursion(now, next, 0) + 1;
            }

            // 전 구역이 경찰서임
            else {
                minValue += Math.min(recursion(now, next, 1), recursion(now, next, 0) + 1);
            }
        }

        return dp[now][isPolice] = minValue;
    }
}