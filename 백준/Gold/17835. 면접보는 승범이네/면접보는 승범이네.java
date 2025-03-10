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
        int k = Integer.parseInt(token.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            graph.get(v).add(new Edge(u, c));
        }

        long[] distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        token = new StringTokenizer(br.readLine(), " ");
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.distance));
        for (int i = 0; i < k; i++) {
            int area = Integer.parseInt(token.nextToken());
            distance[area] = 0;
            pq.add(new Edge(area, 0));
        }

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (distance[now.to] < now.distance) {
                continue;
            }
            for (Edge next : graph.get(now.to)) {
                long newDistance = distance[next.to] == 0 ? 0 : now.distance + next.distance;
                if (distance[next.to] > newDistance) {
                    distance[next.to] = newDistance;
                    pq.add(new Edge(next.to, newDistance));
                }
            }
        }


        int maxDistanceIndex = -1;
        long maxDistance = -1;

        for (int i = 1; i <= n; i++) {
            if (maxDistance < distance[i]) {
                maxDistance = distance[i];
                maxDistanceIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxDistanceIndex).append("\n").append(maxDistance);
        System.out.print(sb);
    }
}

class Edge {

    int to;
    long distance;

    public Edge(int to, long distance) {
        this.to = to;
        this.distance = distance;
    }
}

