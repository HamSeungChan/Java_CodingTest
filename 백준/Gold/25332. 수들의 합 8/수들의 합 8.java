import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sumA = new int[n + 1];
        int[] sumB = new int[n + 1];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            sumA[i] = sumA[i - 1] + Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            sumB[i] = sumB[i - 1] + Integer.parseInt(token.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        long answer = 0;
        for (int i = 0; i <= n; i++) {
            answer += map.getOrDefault(sumA[i] - sumB[i], 0);
            map.put(sumA[i] - sumB[i], map.getOrDefault(sumA[i] - sumB[i], 0) + 1);
        }
        System.out.println(answer);
    }

}