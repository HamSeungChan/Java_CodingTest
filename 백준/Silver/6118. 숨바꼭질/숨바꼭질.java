import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[] depth = new int[n + 1];
        Arrays.fill(depth, -1);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int j = 0; j < m; j++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        depth[1] = 0;
        q.offer(1);

        while (!q.isEmpty()) {
            int now = q.poll();
            List<Integer> nextList = graph.get(now);
            for (Integer next : nextList) {
                if (depth[next] != -1) {
                    continue;
                }
                q.offer(next);
                depth[next] = depth[now] + 1;
            }
        }

        int number = 0;
        int maxDepth = -1;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (maxDepth < depth[i]) {
                number = i;
                maxDepth = depth[i];
                count = 1;
            } else if (maxDepth == depth[i]) {
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(number).append(" ").append(maxDepth).append(" ").append(count);
        System.out.print(sb);
    }
}