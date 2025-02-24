import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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

    public static int[] parent;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Info[] xArray = new Info[n];
        Info[] yArray = new Info[n];
        Info[] zArray = new Info[n];

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            xArray[i] = new Info(i, Integer.parseInt(token.nextToken()));
            yArray[i] = new Info(i, Integer.parseInt(token.nextToken()));
            zArray[i] = new Info(i, Integer.parseInt(token.nextToken()));
        }

        Arrays.sort(xArray);
        Arrays.sort(yArray);
        Arrays.sort(zArray);

        Queue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n - 1; i++) {

            pq.add(new Node(xArray[i + 1].index, xArray[i].index, xArray[i + 1].value - xArray[i].value));
            pq.add(new Node(yArray[i + 1].index, yArray[i].index, yArray[i + 1].value - yArray[i].value));
            pq.add(new Node(zArray[i + 1].index, zArray[i].index, zArray[i + 1].value - zArray[i].value));

        }

        int count = 0;
        int cost = 0;
        while (!pq.isEmpty()) {

            Node now = pq.poll();
            if (union(now.a, now.b)) {
                cost += now.value;
                count++;
            }

            if (count == n - 1) {
                break;
            }

        }

        System.out.println(cost);
    }
}

class Node implements Comparable<Node> {

    int a;
    int b;
    int value;

    public Node(int a, int b, int value) {
        this.a = a;
        this.b = b;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}


class Info implements Comparable<Info> {

    int index;
    int value;

    public Info(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Info o) {
        return this.value - o.value;
    }
}