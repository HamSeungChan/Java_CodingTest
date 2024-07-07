import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());

            graph.get(from).add(new Node(to, value));
        }

        boolean[] check = new boolean[v + 1];
        int[] answer = new int[v + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);

        Queue<Node> pq = new PriorityQueue<>();

        answer[k] = 0;
        pq.add(new Node(k, 0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();
            check[now.to] = true;

            for (Node next : graph.get(now.to)) {

                // 이미 꺼낸 노드라면
                if (check[next.to]) {
                    continue;
                }

                if (answer[next.to] > answer[now.to] + next.value) {
                    answer[next.to] = answer[now.to] + next.value;
                    pq.add(new Node(next.to, answer[next.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(answer[i] != Integer.MAX_VALUE ? answer[i] : "INF").append("\n");
        }
        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {
    int to;
    int value;

    public Node(int to, int value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}