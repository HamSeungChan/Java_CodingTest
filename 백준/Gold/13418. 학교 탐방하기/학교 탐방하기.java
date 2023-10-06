import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
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
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int bestFatigue = 0;
        int worstFatigue = 0;

        token = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(token.nextToken());
        int to = Integer.parseInt(token.nextToken());
        int value = Integer.parseInt(token.nextToken());
        union(from, to);
        if (value == 0) {
            bestFatigue++;
            worstFatigue++;
        }

        PriorityQueue<Node> worst = new PriorityQueue<>();
        PriorityQueue<Node> best = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            from = Integer.parseInt(token.nextToken());
            to = Integer.parseInt(token.nextToken());
            value = Integer.parseInt(token.nextToken());
            Node node = new Node(from, to, value);
            worst.offer(node);
            best.offer(node);
        }

        for (int i = 0; i < m; i++) {
            Node worstNode = worst.poll();
            if (union(worstNode.from, worstNode.to)) {
                if (worstNode.value == 0) {
                    worstFatigue++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            Node bestNode = best.poll();
            if (union(bestNode.from, bestNode.to)) {
                if (bestNode.value == 0) {
                    bestFatigue++;
                }
            }
        }
        
        System.out.println((int) (Math.pow(worstFatigue, 2) - Math.pow(bestFatigue, 2)));
    }
}

class Node implements Comparable<Node> {
    int from;
    int to;

    public Node(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    int value;

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}