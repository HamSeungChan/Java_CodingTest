import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 마산까지의 최단거리와 건우까지의 최단거리 + 건우 위치에서 마산까지의 최단거리 비교
 *
 * */

public class Main {

    static int v;

    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        // 정점의 개수
        v = Integer.parseInt(token.nextToken());
        // 간선의 개수
        int e = Integer.parseInt(token.nextToken());
        // 건우의 위치
        int p = Integer.parseInt(token.nextToken());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        
        System.out.println(dijkstra(1, v) == dijkstra(1, p) + dijkstra(p, v) ? "SAVE HIM" : "GOOD BYE");
    }

    public static int dijkstra(int start, int end) {
        int[] value = new int[v + 1];
        Arrays.fill(value, Integer.MAX_VALUE);
        value[start] = 0;

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            List<Node> nextNodes = graph.get(now.to);
            for (Node next : nextNodes) {
                if (value[next.to] > now.weight + next.weight) {
                    value[next.to] = now.weight + next.weight;
                    pq.offer(new Node(next.to, now.weight + next.weight));
                }
            }
        }
        return value[end];
    }
}

class Node implements Comparable<Node> {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}