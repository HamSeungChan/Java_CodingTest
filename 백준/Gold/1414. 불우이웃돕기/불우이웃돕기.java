import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }


        int totalValue = 0;
        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            List<Node> now = graph.get(i);
            for (int j = 0; j < n; j++) {
                if (chars[j] == '0') {
                    continue;
                }

                int weight = -1;
                if (Character.isLowerCase(chars[j])) {
                    weight = chars[j] - 'a' + 1;
                } else {
                    weight = chars[j] - 'A' + 27;
                }


                now.add(new Node(j, weight));
                graph.get(j).add(new Node(i, weight));
                totalValue += weight;
            }
        }

        boolean[] check = new boolean[n];
        pq.add(new Node(0, 0));

        int value = 0;
        int count = 0;
        while (!pq.isEmpty()) {

            Node now = pq.poll();
            if (check[now.to]) {
                continue;
            }

            check[now.to] = true;
            value += now.value;
            count++;

            for (Node node : graph.get(now.to)) {
                pq.add(node);
            }
        }

        if (count != n) {
            System.out.println(-1);
        } else {
            System.out.println(totalValue - value);
        }
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