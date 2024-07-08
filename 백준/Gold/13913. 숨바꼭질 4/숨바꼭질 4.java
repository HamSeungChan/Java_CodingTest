import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int answer = 0;
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[] check = new int[100001];
        Arrays.fill(check, -1);

        q = new LinkedList<>();
        q.offer(n);
        check[n] = 0;
        int depth = 0;


        while (!q.isEmpty()) {

            int size = q.size();
            for (int s = 0; s < size; s++) {
                int now = q.poll();

                if (now == k) {
                    answer = depth;
                }

                move(now, 1, check);
                move(now, -1, check);
                move(now, now, check);
            }
            depth++;
        }

        int[] route = new int[answer + 1];
        int value = k;
        for (int i = answer; i >= 0; i--) {
            route[i] = value;
            value = check[value];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");

        for (int i : route) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }

    public static void move(int now, int moving, int[] check) {

        int next = now + moving;
        if (next < 0 || next > 100000 || check[next] != -1) {
            return;
        }

        check[next] = now;
        q.offer(next);
    }
}