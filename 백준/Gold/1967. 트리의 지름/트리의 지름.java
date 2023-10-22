import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int endNodeIndex = 0;
    static int maxValue = 0;
    static boolean[] check;

    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer token;
        for (int i = 0; i < n - 1; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());

            list.get(a).add(new Node(b, value));
            list.get(b).add(new Node(a, value));
        }


        check = new boolean[n + 1];
        check[1] = true;
        dfs(1, 0);


        check = new boolean[n + 1];
        maxValue = 0;
        check[endNodeIndex] = true;
        dfs(endNodeIndex, 0);
        
        System.out.println(maxValue);

    }

    public static void dfs(int from, int value) {

        if (maxValue < value) {
            maxValue = value;
            endNodeIndex = from;
        }

        for (Node node : list.get(from)) {
            if (check[node.to] == false) {
                check[node.to] = true;
                dfs(node.to, value + node.value);
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