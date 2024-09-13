import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][2];

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (pq.size() < array[i][0]) {
                pq.add(array[i][1]);
            } else {
                if (pq.peek() < array[i][1]) {
                    pq.poll();
                    pq.add(array[i][1]);
                }
            }
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.println(answer);

    }
}