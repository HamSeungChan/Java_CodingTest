import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    static int find(int value) {
        if (parents[value] == value) {
            return value;
        }
        return parents[value] = find(parents[value]);
    }

    static boolean union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA == findB) {
            return false;
        }

        parents[findA] = findB;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }

            int totalValue = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(token.nextToken());
                int to = Integer.parseInt(token.nextToken());
                int weight = Integer.parseInt(token.nextToken());
                totalValue += weight;
                pq.offer(new Node(from, to, weight));
            }

            int useValue = 0;
            while (!pq.isEmpty()) {
                Node tmp = pq.poll();
                if (union(tmp.from, tmp.to)) {
                    useValue += tmp.weight;
                }
            }
            sb.append(totalValue - useValue).append("\n");
        }
        System.out.print(sb);
    }
}

class Node implements Comparable<Node> {
    int from;
    int to;
    int weight;

    public Node(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}