import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[] array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int lt = 0;
        int sum = 0;
        int answer = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += array[rt];
            while (sum > m) {
                sum -= array[lt];
                lt++;
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}