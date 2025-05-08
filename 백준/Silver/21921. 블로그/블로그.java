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

        int[] prefixSum = new int[n + 1];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(token.nextToken());
        }

        int maxValue = 0;
        int count = 0;

        for (int i = k; i <= n; i++) {
            int value = prefixSum[i] - prefixSum[i - k];
            if (value > maxValue) {
                maxValue = value;
                count = 1;
                continue;
            }

            if (value == maxValue) {
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxValue).append("\n").append(count);
        System.out.print(maxValue == 0 ? "SAD" : sb);
    }
}
