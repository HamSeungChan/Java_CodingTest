import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] visit;
    static int order = 1;
    static int n, m, r;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());

        visit = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int to = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());

            graph.get(to).add(from);
            graph.get(from).add(to);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
        dfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <=n; i++){
            sb.append(visit[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int now) {

        visit[now] = order++;
        List<Integer> list = graph.get(now);
        for (Integer next : list) {
            if (visit[next] == 0) {
                dfs(next);
            }
        }
    }
}