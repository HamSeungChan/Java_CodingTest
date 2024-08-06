import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int[] array = new int[n];
        int m = Integer.parseInt(token.nextToken());

        int size = 0;
        long answer = 0;
        long sum = 0;
        int lt = 0;


        token = new StringTokenizer(br.readLine(), " ");
        for (int rt = 0; rt < n; rt++) {

            int tmp = Integer.parseInt(token.nextToken());
            array[rt] = tmp;

            if (size == m) {
                sum -= array[lt];
                lt++;
                size--;
            }
            sum += array[rt];
            answer = Math.max(answer, sum);
            size++;
        }
        System.out.println(answer);
    }
}