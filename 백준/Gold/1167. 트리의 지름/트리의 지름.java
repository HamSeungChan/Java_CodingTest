import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Node>> list = new ArrayList<>();
    static int maxValue = 0;
    static int index = 0;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        StringTokenizer token;

        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }


        for (int i = 0; i < v; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(token.nextToken());

            while (true) {
                int to = Integer.parseInt(token.nextToken());
                if (to == -1) {
                    break;
                }
                int value = Integer.parseInt(token.nextToken());
                list.get(from).add(new Node(to, value));
                list.get(to).add(new Node(from, value));
            }

        }

        check = new boolean[v + 1];
        check[1] = true;
        dfs(1, 0);


        maxValue = 0;
        check = new boolean[v + 1];
        check[index] = true;
        dfs(index, 0);

        System.out.println(maxValue);
    }

    public static void dfs(int from, int value) {
        if (maxValue < value) {
            maxValue = value;
            index = from;
        }

        for (Node tmp : list.get(from)) {
            if (!check[tmp.to]) {
                check[tmp.to] = true;
                dfs(tmp.to, value + tmp.value);
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