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

        int[] array = new int[n + 1];
        int[] sumArray = new int[n + 1];
        token = new StringTokenizer(br.readLine(), " ");

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
            sum += array[i];
            sumArray[i] = sum;
        }

        StringBuffer sb = new StringBuffer();

        for (int k = 0; k < m; k++) {
            token = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(token.nextToken());
            int j = Integer.parseInt(token.nextToken());

            sb.append(sumArray[j] - sumArray[i - 1]).append("\n");
        }
        System.out.println(sb);
    }
}