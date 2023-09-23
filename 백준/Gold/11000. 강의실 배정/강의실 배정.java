import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][2];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(token.nextToken());
            array[i][1] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        q.offer(array[0][1]);

        for (int i = 1; i < n; i++) {
            if (q.peek() <= array[i][0]) q.poll();
            q.offer(array[i][1]);
        }

        System.out.println(q.size());
    }
}