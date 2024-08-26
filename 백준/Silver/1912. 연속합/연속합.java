import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prefixSum = new int[n + 1];

        int answer = Integer.MIN_VALUE;
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(token.nextToken());
            prefixSum[i] = Math.max(prefixSum[i - 1] + value, value);
            answer = Math.max(answer, prefixSum[i]);
        }
        System.out.println(answer);
    }
}