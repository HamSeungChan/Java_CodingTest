import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Node>> list;
    static int n, m, start, end;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer token;
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int weight = Integer.parseInt(token.nextToken());

            list.get(from).add(new Node(to, weight));
        }

        token = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(token.nextToken());
        end = Integer.parseInt(token.nextToken());

        long[] value = new long[n + 1];
        int[] direction = new int[n + 1];

        Arrays.fill(value, Long.MAX_VALUE);
        check = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        value[start] = 0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            if (tmp.value > value[tmp.to]) continue;
            for (Node node : list.get(tmp.to)) {
                if (value[node.to] > value[tmp.to] + node.value) {
                    value[node.to] = value[tmp.to] + node.value;
                    direction[node.to] = tmp.to;
                    pq.offer(new Node(node.to, value[tmp.to] + node.value));
                }
            }
        }


        System.out.println(value[end]);
        int cnt = 0;
//        StringBuilder sb = new StringBuilder();
//        sb.append(end);
//        int count = 1;
//        while (end != start) {
//            end = direction[end];
//            sb.append(" ").append(end);
//            count++;
//        }
//        System.out.println(count);
//        System.out.print(sb.reverse().toString());
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while (direction[end] != 0) {
            cnt += 1;
            stack.push(direction[end]);
            end = direction[end];
        }
        System.out.println(cnt + 1);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

class Node implements Comparable<Node> {
    int to;
    long value;

    public Node(int to, long value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.value, o.value);
    }
}