import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n + 1];
        long[] sum = new long[n + 1];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(array);

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + array[i];
        }


        long answer = 0;

        for (int i = 1; i < n; i++) {
            answer += ((sum[n] - sum[i]) - (long)array[i] * (n - i)) * 2;
        }

        System.out.println(answer);
    }
}