import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        List<List<Node>> list = new ArrayList<>();

        int[] value = new int[n + 1];
        Arrays.fill(value, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int weight = Integer.parseInt(token.nextToken());
            list.get(from).add(new Node(to, weight));
            list.get(to).add(new Node(from, weight));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        value[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.weight > value[now.to]) continue;

            for (Node next : list.get(now.to)) {
                if (value[next.to] > value[now.to] + next.weight) {
                    value[next.to] = value[now.to] + next.weight;
                    pq.offer(new Node(next.to, value[next.to]));
                }
            }
        }
        
        System.out.println(value[n]);
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