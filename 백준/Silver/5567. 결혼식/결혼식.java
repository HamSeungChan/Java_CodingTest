import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.println(bfs(1));
    }

    public static int bfs(int start) {
        int answer = 0;
        check[start] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        int depth = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                for (Integer next : graph.get(now)) {
                    if (!check[next]) {
                        q.offer(next);
                        answer++;
                        check[next] = true;
                    }
                }
            }
            depth++;
            if (depth == 2) {
                break;
            }
        }
        return answer;
    }

}