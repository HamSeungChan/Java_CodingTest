import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[] array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int value = 0;
        for (int i = 0; i < k; i++) {
            value += array[i];
        }

        max = Math.max(max, value);

        int lt = 0;
        for (int i = k; i < n; i++) {
            value = value - array[lt++] + array[i];
            max = Math.max(max, value);
        }
        System.out.println(max);
    }
}