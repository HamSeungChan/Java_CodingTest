import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] sum = new int[n + 1];

            int max = -100000000;
            token = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= n; j++) {
                int value = Integer.parseInt(token.nextToken());
                sum[j] = Math.max(sum[j - 1] + value, value);
                max = Math.max(max, sum[j]);
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}