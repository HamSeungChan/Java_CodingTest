import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static boolean union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA == findB) {
            return false;
        }
        parent[findA] = findB;
        return true;
    }

    public static int find(int value) {
        if (value == parent[value]) {
            return value;
        }
        return parent[value] = find(parent[value]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        token = new StringTokenizer(br.readLine(), " ");
        int knowPeopleCount = Integer.parseInt(token.nextToken());
        for (int i = 0; i < knowPeopleCount; i++) {
            union(0, Integer.parseInt(token.nextToken()));
        }

        int[] firstMember = new int[m];

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int peopleCount = Integer.parseInt(token.nextToken());
            firstMember[i] = Integer.parseInt(token.nextToken());
            for (int j = 1; j < peopleCount; j++) {
                union(firstMember[i], Integer.parseInt(token.nextToken()));
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (find(0) != find(firstMember[i])) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}