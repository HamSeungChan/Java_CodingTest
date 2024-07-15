import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            graph.get(from).add(to);
        }

        System.out.println(bfs());
    }

    public static int bfs() {

        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[200001];
        int depth = 0;
        check[1] = true;
        q.add(1);

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();

                if (tmp == n) {
                    return depth;
                }

                List<Integer> nextList = graph.get(tmp);
                for (Integer next : nextList) {
                    if (!check[next]) {
                        check[next] = true;
                        q.offer(next);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}