import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Node>> list;
    static boolean[] check;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            list = new ArrayList<>();

            int n = Integer.parseInt(token.nextToken());
            int d = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            check = new boolean[n + 1];
            answer = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            Arrays.fill(answer, Integer.MAX_VALUE);
            answer[c] = 0;

            for (int i = 0; i < d; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                int s = Integer.parseInt(token.nextToken());
                list.get(b).add(new Node(a, s));
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                int index = -1;
                int minValue = Integer.MAX_VALUE;

                for (int j = 1; j <= n; j++) {
                    if (answer[j] < minValue && !check[j]) {
                        index = j;
                        minValue = answer[j];
                    }
                }

                if (index == -1) {
                    break;
                }

                count++;
                check[index] = true;

                List<Node> tmp = list.get(index);
                for (Node node : tmp) {
                    if (!check[node.to] && answer[node.to] > minValue + node.weight) {
                        answer[node.to] = minValue + node.weight;
                    }
                }
            }
            int maxValue = 0;
            for (int i : answer) {
                if (i != Integer.MAX_VALUE) {
                    maxValue = Math.max(maxValue, i);
                }
            }
            sb.append(count).append(" ").append(maxValue).append("\n");
        }
        System.out.print(sb);
    }
}

class Node implements Comparable<Node> {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}