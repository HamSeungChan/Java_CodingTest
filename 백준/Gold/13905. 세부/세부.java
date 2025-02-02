import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;

    public static int find(int value) {

        if (value == parent[value]) {
            return value;
        }

        return parent[value] = find(parent[value]);
    }

    public static boolean union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        // 이미 같은 그룹
        if (findA == findB) {
            return false;
        }

        parent[findA] = findB;
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        // 집의 수
        int n = Integer.parseInt(token.nextToken());
        // 다리의 수
        int m = Integer.parseInt(token.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        token = new StringTokenizer(br.readLine(), " ");
        // 숭이의 출발 위치
        int s = Integer.parseInt(token.nextToken());
        // 혜빈이의 위치
        int e = Integer.parseInt(token.nextToken());

        // 무게제한이 높은 다리 부터
        Queue<Bridge> pq = new PriorityQueue<>((o1, o2) -> o2.weight - o1.weight);
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int weight = Integer.parseInt(token.nextToken());

            pq.add(new Bridge(from, to, weight));
        }

        int answer = 0;
        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {

            Bridge poll = pq.poll();
            if (union(poll.to, poll.from)) {
                min = Math.min(min, poll.weight);
            }

            if (find(s) == find(e)) {
                answer = min;
                break;
            }
        }


        System.out.println(answer);
    }
}

class Bridge {
    int from;
    int to;
    int weight;

    public Bridge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}