import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] value;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        value = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        token = new StringTokenizer(br.readLine(), " ");
        token.nextToken();
        for (int i = 2; i <= n; i++) {
            int tmp = Integer.parseInt(token.nextToken());
            graph.get(i).add(tmp);
            graph.get(tmp).add(i);
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int index = Integer.parseInt(token.nextToken());
            int w = Integer.parseInt(token.nextToken());
            value[index] += w;
        }

        dfs(1, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(value[i]).append(" ");
        }
        System.out.print(sb);
    }

    public static void dfs(int now, int before) {
        List<Integer> nextList = graph.get(now);
        for (int next : nextList) {
            if (next == before) {
                continue;
            }
            value[next] += value[now];
            dfs(next, now);
        }
    }
}