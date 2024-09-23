import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        // 건물의 수
        int n = Integer.parseInt(token.nextToken());
        // 털린 금음방
        int s = Integer.parseInt(token.nextToken());
        // 대도 X의 집
        int d = Integer.parseInt(token.nextToken());
        // 앞으로 한 번에 달릴 수 있는 건물 수
        int f = Integer.parseInt(token.nextToken());
        // 뒤로 한 번에 달릴 수 있는 건물 수
        int b = Integer.parseInt(token.nextToken());
        // 경찰서의 개수
        int k = Integer.parseInt(token.nextToken());

        boolean[] police = new boolean[n + 1];
        if (k > 0) {
            token = new StringTokenizer(br.readLine(), " ");
        }
        for (int i = 0; i < k; i++) {
            police[Integer.parseInt(token.nextToken())] = true;
        }

        boolean[] check = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        check[s] = true;

        int depth = 0;
        int answer = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                int now = q.poll();
                if (now == d) {
                    answer = depth;
                    break;
                }

                int front = now + f;
                if (1 <= front && front <= n && !check[front] && !police[front]) {
                    q.add(front);
                    check[front] = true;
                }

                int back = now - b;
                if (1 <= back && back <= n && !check[back] && !police[back]) {
                    q.add(back);
                    check[back] = true;
                }
            }
            depth++;
        }
        System.out.println(answer != -1 ? answer : "BUG FOUND");
    }
}