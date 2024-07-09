import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int r = Integer.parseInt(token.nextToken());
        int q = Integer.parseInt(token.nextToken());

        size = new int[n + 1];
        Arrays.fill(size, 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < n - 1; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(r, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(size[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int now, int before) {

        List<Integer> nextList = graph.get(now);
        for (int next : nextList) {
            if (next == before) {
                continue;
            }
            dfs(next, now);
            size[now] += size[next];
        }
    }
}