import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] gift = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(token.nextToken()));
        }


        int[] child = new int[m];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            child[i] = Integer.parseInt(token.nextToken());
        }

        solution(pq, child);
    }

    public static void solution(Queue<Integer> pq, int[] child) {
        for (int i = 0; i < child.length; i++) {
            int max = pq.poll();
            if (max >= child[i]) {
                pq.add(max - child[i]);
            } else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
