import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int maxDepth = -1, maxIndex = -1;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

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

        dfs(-1, 1, 0);
        maxDepth = 0;
        dfs(-1, maxIndex, 0);
        System.out.println((maxDepth + 1) / 2);
    }

    public static void dfs(int before, int now, int depth) {

        if (maxDepth < depth) {
            maxDepth = depth;
            maxIndex = now;
        }

        for (Integer next : graph.get(now)) {
            if (before == next) {
                continue;
            }
            dfs(now, next, depth + 1);
        }
    }
}