import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] check;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        check = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        long answer = 1;
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {

                int count = bfs(i);
                if (count == 1) {
                    continue;
                }
                answer = (answer % MOD) * (count % MOD) % MOD;
            }
        }
        System.out.println(answer);
    }

    public static int bfs(int start) {

        int count = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (!check[next]) {
                    count++;
                    check[next] = true;
                    q.offer(next);
                }
            }
        }
        return count;
    }
}