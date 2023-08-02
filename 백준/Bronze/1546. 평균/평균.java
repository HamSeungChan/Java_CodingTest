import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
            max = Math.max(max, array[i]);
        }

        double sum = 0;
        for (int x : array) {
            sum += (double) x / max * 100;
        }
        System.out.println(sum / n);
    }
}