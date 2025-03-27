import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Info>> graph = new ArrayList<>();
    static int[] distance;
    static int[] parent;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            graph.get(a).add(new Info(b, c));
            graph.get(b).add(new Info(a, c));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            recursion(-1, a, b, 0);
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static void recursion(int before, int now, int goal, int value) {

        if (goal == now) {
            answer = value;
            return;
        }

        for (Info next : graph.get(now)) {
            if (next.to == before) {
                continue;
            }

            recursion(now, next.to, goal, value + next.distance);
        }
    }
}

class Info {
    int to;
    int distance;

    public Info(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}
