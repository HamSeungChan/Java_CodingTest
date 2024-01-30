import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        PriorityQueue<Jewel> mpq = new PriorityQueue<>(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o1.m - o2.m;
            }
        });


        PriorityQueue<Integer> vpq = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());
            mpq.offer(new Jewel(m, v));
        }


        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        long answer = 0;
        for (int i = 0; i < k; i++) {
            int max = bag[i];
            while (!mpq.isEmpty() && mpq.peek().m <= max) {
                Jewel poll = mpq.poll();
                vpq.offer(poll.v);
            }
            if (!vpq.isEmpty()) {
                answer += vpq.poll();
            }
        }
        System.out.println(answer);
    }
}


class Jewel {
    int m;
    int v;

    public Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }
}