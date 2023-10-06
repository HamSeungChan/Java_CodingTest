import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    static boolean union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        if (findA == findB) {
            return false;
        }
        parents[findA] = findB;
        return true;
    }

    static int find(int value) {
        if (parents[value] == value) {
            return value;
        }
        return parents[value] = find(parents[value]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }


        token = new StringTokenizer(br.readLine());
        int powerPlant = Integer.parseInt(token.nextToken());
        for (int i = 0; i < k - 1; i++) {
            union(powerPlant, Integer.parseInt(token.nextToken()));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());
            pq.offer(new Node(from, to, value));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            if (union(tmp.to, tmp.from)) {
                answer += tmp.value;
            }
        }
        System.out.println(answer);
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