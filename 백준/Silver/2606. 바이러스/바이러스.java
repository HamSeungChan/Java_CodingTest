import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이중 리스트
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 네트워크 연결 정보
        int k = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for (int i = 0; i < k; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1, new boolean[n + 1]);
        System.out.println(count);
    }

    public static void dfs(int next, boolean[] check) {

        check[next] = true;

        List<Integer> list = graph.get(next);
        for (Integer i : list) {
            if (!check[i]) {
                count++;
                dfs(i, check);
            }
        }
    }
}