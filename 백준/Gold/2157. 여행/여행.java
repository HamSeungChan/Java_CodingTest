import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<List<Info>> graph = new ArrayList<>();
    static int[][] dp;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());

            if (a > b) {
                continue;
            }
            graph.get(a).add(new Info(b, cost));
        }

        int result = recursion(1, 1);
        System.out.println(flag ? result :0);
    }

    public static int recursion(int index, int count) {

        if (dp[index][count] != -1) {
            return dp[index][count];
        }

        if (index == n) {
            flag = true;
            return 0;
        }

        if (count == m) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        List<Info> next = graph.get(index);
        for (Info info : next) {
            max = Math.max(max, recursion(info.to, count + 1) + info.cost);
        }

        return dp[index][count] = max;
    }
}

class Info {
    int to;
    int cost;

    public Info(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
