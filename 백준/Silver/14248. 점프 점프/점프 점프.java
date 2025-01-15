import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 1];


        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();

        int answer = 1;
        check[s] = true;
        q.add(s);

        while (!q.isEmpty()) {

            int now = q.poll();

            int next1 = now - array[now];
            int next2 = now + array[now];

            if (1 <= next1 && next1 <= n && !check[next1]) {
                q.add(next1);
                check[next1] = true;
                answer++;
            }

            if (1 <= next2 && next2 <= n && !check[next2]) {
                q.add(next2);
                check[next2] = true;
                answer++;
            }

        }

        System.out.println(answer);

    }
}