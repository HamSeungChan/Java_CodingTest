import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
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

        StringBuilder sb = new StringBuilder();
        dfs(-1, 1);

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int before, int now) {

        for (Integer next : graph.get(now)) {
            if (next == before) {
                continue;
            }

            parent[next] = now;

            dfs(now, next);
        }
    }

}