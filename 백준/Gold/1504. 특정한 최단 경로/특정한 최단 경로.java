import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());

            graph.get(a).add(new Edge(b, value));
            graph.get(b).add(new Edge(a, value));
        }

        token = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        // start -> a -> b -> end

        int sum1 = 0;
        sum1 += getValue(1, a);
        int route = getValue(a, b);
        sum1 += route;
        sum1 += getValue(b, n);

        int sum2 = 0;
        sum2 += getValue(1, b);
        sum2 += getValue(b, a);
        sum2 += getValue(a, n);

        System.out.println((sum1 >= 200000000 && sum2 >= 200000000) ? -1 : Math.min(sum1, sum2));
    }

    public static int getValue(int start, int end) {

        Queue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.to == end) {
                return now.value;
            }

            for (Edge next : graph.get(now.to)) {
                int newValue = now.value + next.value;
                if (dist[next.to] > newValue) {
                    dist[next.to] = newValue;
                    pq.add(new Edge(next.to, now.value + next.value));
                }
            }
        }

        return 200000000;
    }

}

class Edge implements Comparable<Edge> {
    int to;
    int value;

    public Edge(int to, int value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}
