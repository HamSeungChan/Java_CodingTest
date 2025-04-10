import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static int find(int value) {
        if (parent[value] == value) {
            return value;
        }
        return parent[value] = find(parent[value]);
    }

    public static boolean union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        if (findA == findB) {
            return false;
        }
        parent[findA] = findB;
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        for (int t = 0; t < testCase; t++) {

            Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

            token = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            parent = new int[r * c];
            for (int i = 0; i < r * c; i++) {
                parent[i] = i;
            }

            int target = 0;
            for (int i = 0; i < r; i++) {
                token = new StringTokenizer(br.readLine());
                for (int j = 0; j < c - 1; j++) {
                    pq.add(new Edge(target, target + 1, Integer.parseInt(token.nextToken())));
                    target++;
                }
                target++;
            }

            target = 0;
            for (int i = 0; i < r - 1; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < c; j++) {
                    pq.add(new Edge(target, target + c, Integer.parseInt(token.nextToken())));
                    target++;
                }
            }

            int answer = 0;
            int pickCount = 0;
            int maxPickCount = r * c - 1;
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                if (union(edge.x, edge.y)) {
                    answer += edge.weight;
                    pickCount++;
                }

                if (pickCount == maxPickCount) {
                    break;
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}

class Edge {
    int x;
    int y;
    int weight;

    public Edge(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}
