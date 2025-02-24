import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());
        long[] sumA = new long[n + 1];
        Map<Long, Long> mapA = new HashMap<>();
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            sumA[i] = sumA[i - 1] + Long.parseLong(token.nextToken());
            mapA.put(sumA[i], mapA.getOrDefault(sumA[i], 0L) + 1);

            for (int j = 1; j < i; j++) {
                long tmp = sumA[i] - sumA[j];
                mapA.put(tmp, mapA.getOrDefault(tmp, 0L) + 1);
            }
        }


        int m = Integer.parseInt(br.readLine());
        long[] sumB = new long[m + 1];
        Map<Long, Long> mapB = new HashMap<>();
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= m; i++) {
            sumB[i] = sumB[i - 1] + Long.parseLong(token.nextToken());
            mapB.put(sumB[i], mapB.getOrDefault(sumB[i], 0L) + 1);

            for (int j = 1; j < i; j++) {
                long tmp = sumB[i] - sumB[j];
                mapB.put(tmp, mapB.getOrDefault(tmp, 0L) + 1);
            }
        }

        long answer = 0;

        for (Long keyA : mapA.keySet()) {
            long aCount = mapA.get(keyA);

            if (mapB.containsKey(t - keyA)) {
                answer += (aCount * mapB.get(t - keyA));
            }
        }

        System.out.println(answer);
    }
}