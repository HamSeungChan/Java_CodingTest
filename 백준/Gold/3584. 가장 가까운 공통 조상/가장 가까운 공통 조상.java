import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph;
    static int answer;
    static boolean flag;
    static int[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {

            int n = Integer.parseInt(br.readLine());
            boolean[] isChild = new boolean[n + 1];
            check = new int[n + 1];
            flag = false;

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            StringTokenizer token;
            for (int i = 0; i < n - 1; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());

                // 자식 노드이다.
                isChild[b] = true;
                graph.get(a).add(b);
            }

            token = new StringTokenizer(br.readLine(), " ");

            int findA = Integer.parseInt(token.nextToken());
            int findB = Integer.parseInt(token.nextToken());

            check[findA] = 1;
            check[findB] = 1;

            // root 노드를 찾는다.
            int rootNode = -1;
            for (int i = 1; i <= n; i++) {
                if (!isChild[i]) {
                    rootNode = i;
                    break;
                }
            }
            dfs(rootNode);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int now) {
        List<Integer> nextList = graph.get(now);
        for (int next : nextList) {
            dfs(next);
            check[now] += check[next];

            if (flag) {
                return;
            }

            if (check[now] == 2) {
                answer = now;
                flag = true;
                return;
            }
        }
    }

}