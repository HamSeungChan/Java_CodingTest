import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        boolean[] check = new boolean[n];
        StringBuilder sb = new StringBuilder();

        int count = 0;
        int index = 0;

        while (true) {
            sb.append(index + 1).append(" ");
            count++;

            if (count == n) {
                break;
            }

            check[index] = true;

            int value = array[index] > 0 ? 1 : -1;
            int end = Math.abs(array[index]);

            for (int i = 0; i < end; i++) {
                do {

                    index = index + value;

                    if (index == -1) {
                        index = n - 1;
                    }

                    if (index == n) {
                        index = 0;
                    }

                } while (check[index]);
            }
        }
        System.out.print(sb);
    }
}