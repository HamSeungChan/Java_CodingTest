import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

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

        boolean[] check = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                count++;
                dfs(i, check);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int next, boolean[] check) {

        check[next] = true;
        List<Integer> list = graph.get(next);
        for (Integer i : list) {
            if (!check[i]) {
                dfs(i, check);
            }
        }
    }
}