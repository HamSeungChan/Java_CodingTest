import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prefixSum = new int[n + 1];

        int totalDistance = 0;
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(br.readLine());
            prefixSum[i] = prefixSum[i - 1] + value;
            totalDistance += value;
        }

        int answer = 0;
        int lt = 0;
        for (int rt = 1; rt <= n; rt++) {
            int distance1 = prefixSum[rt] - prefixSum[lt];
            int distance2 = totalDistance - distance1;

            answer = Math.max(answer, Math.min(distance1, distance2));

            while (distance1 >= distance2) {
                lt++;
                distance1 = prefixSum[rt] - prefixSum[lt];
                distance2 = totalDistance - distance1;
                answer = Math.max(answer, Math.min(distance1, distance2));
            }
        }

        System.out.println(answer);
    }
}
