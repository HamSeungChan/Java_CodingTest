import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    static int find(int value) {
        if (parents[value] == value) {
            return value;
        }
        return parents[value] = find(parents[value]);
    }

    static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            parents[findA] = findB;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[n + 1];
        parents = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 2; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            check[a] = true;
            check[b] = true;
            union(a, b);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(find(i));
        }

        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            sb.append(next).append(" ");
        }

        System.out.println(sb);
    }
}