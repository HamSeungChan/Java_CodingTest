import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check = new int[n + 1];
        Arrays.fill(check, -1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(token.nextToken());
        check[from] = 0;
        int to = Integer.parseInt(token.nextToken());

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(from);
        System.out.println(check[to]);
    }

    public static void dfs(int now) {
        List<Integer> list = graph.get(now);
        for (Integer i : list) {
            if (check[i] == -1) {
                check[i] = check[now] + 1;
                dfs(i);
            }
        }

    }
}