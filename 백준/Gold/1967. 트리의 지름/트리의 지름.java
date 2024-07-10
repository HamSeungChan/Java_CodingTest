/*
 * 트리의 지름은 한 점에서 가장 먼 노드를 구하고,
 * 그 점에서 또 가장 먼 노드를 구하면 그게 트리의 지름이다.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Info>> graph = new ArrayList<>();
    static int[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        StringTokenizer token;
        for (int i = 0; i < n - 1; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            graph.get(a).add(new Info(b, c));
            graph.get(b).add(new Info(a, c));
        }

        int answer = 0;
        check = new int[n + 1];
        dfs(1, -1);

        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (check[i] > maxValue) {
                maxIndex = i;
                maxValue = check[i];
            }
        }

        check = new int[n + 1];
        dfs(maxIndex, -1);


        maxValue = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (check[i] > maxValue) {
                maxValue = check[i];
            }
        }
        System.out.println(maxValue);
    }

    public static void dfs(int now, int before) {

        List<Info> nextList = graph.get(now);
        for (Info next : nextList) {
            if (next.to == before) {
                continue;
            }
            check[next.to] = check[now] + next.weight;
            dfs(next.to, now);
        }
    }
}

class Info {
    int to;
    int weight;

    public Info(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}