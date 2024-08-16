import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n + 1];
        int[] sum = new int[n + 1];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
            sum[i] = sum[i - 1] + (array[i - 1] > array[i] ? 1 : 0);
        }

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            sb.append(sum[end] - sum[start]).append("\n");
        }
        System.out.println(sb);
    }
}