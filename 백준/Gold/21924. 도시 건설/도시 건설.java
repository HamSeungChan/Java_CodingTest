import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        long totalValue = 0;
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());
            totalValue += value;
            pq.offer(new Node(from, to, value));
        }

        long mst = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            if (union(tmp.from, tmp.to)) {
                mst += tmp.value;
                count++;
            }
        }

        long answer = totalValue - mst;

        if (count != n - 1) {
            answer = -1;
        }

        System.out.println(answer);
    }

    public static int find(int value) {
        if (parents[value] == value) {
            return value;
        }
        return parents[value] = find(parents[value]);
    }

    public static boolean union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA == findB) {
            return false;
        }

        parents[findA] = findB;
        return true;
    }

}

class Node implements Comparable<Node> {
    int from;
    int to;
    int value;

    public Node(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }


    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}