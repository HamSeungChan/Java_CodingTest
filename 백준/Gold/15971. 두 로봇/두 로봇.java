import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int r1 = Integer.parseInt(token.nextToken());
        int r2 = Integer.parseInt(token.nextToken());

        for (int i = 0; i < n - 1; i++) {

            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());

            graph.get(a).add(new Node(b, value));
            graph.get(b).add(new Node(a, value));
        }

        int[] array1 = new int[n + 1];
        dfs(r1, array1, new boolean[n + 1]);
        int[] array2 = new int[n + 2];
        dfs(r2, array2, new boolean[n + 1]);

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            List<Node> nodes = graph.get(i);
            for (Node node : nodes) {
                answer = Math.min(array1[i] + array2[node.to], answer);
                answer = Math.min(array2[i] + array1[node.to], answer);
            }
        }

        if (n == 1 || r1 == r2) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }

    }

    public static void dfs(int now, int[] array, boolean[] check) {

        check[now] = true;
        List<Node> nodes = graph.get(now);
        for (Node next : nodes) {
            if (!check[next.to]) {
                array[next.to] += array[now] + next.value;
                dfs(next.to, array, check);
            }
        }
    }
}

class Node {
    int to;
    int value;

    public Node(int to, int value) {
        this.to = to;
        this.value = value;
    }
}