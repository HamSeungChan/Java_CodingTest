import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int answer;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {

            int next = Integer.parseInt(br.readLine());
            graph.get(i).add(next);
        }

        int max = 0;
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            int dfs = dfs(new boolean[n + 1], i);
            if (dfs > max) {
                max = dfs;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    public static int dfs(boolean[] check, int now) {

        List<Integer> next = graph.get(now);
        check[now] = true;

        int count = 0;
        for (int i = 0; i < next.size(); i++) {
            if (!check[next.get(i)]) {
                count = dfs(check, next.get(i)) + 1;
            }
        }

        return count;
    }

}