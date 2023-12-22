import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;
    static int[] cost;

    static int find(int value) {

        if (value == parents[value]) {
            return value;
        }

        return parents[value] = find(parents[value]);
    }

    static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            if (cost[findA] < cost[findB]) {
                parents[findB] = findA;
            } else {
                parents[findA] = findB;
            }
        }
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

        // 학생들이 요구하는 친구비
        token = new StringTokenizer(br.readLine(), " ");
        cost = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            union(a, b);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(find(i));
        }

        Iterator<Integer> iterator = set.iterator();
        long sum = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
//            System.out.println(next);
            sum += cost[next];
        }

        if (sum > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(sum);
        }
    }
}