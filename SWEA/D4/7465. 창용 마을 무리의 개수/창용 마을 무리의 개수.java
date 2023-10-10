import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

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
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());

            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                if (union(a, b)) ;
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                set.add(find(parents[i]));
            }
            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        }
        System.out.print(sb);
    }
}