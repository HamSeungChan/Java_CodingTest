import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        long k = Long.parseLong(token.nextToken());

        long answer = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        long[] array = new long[n + 1];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            array[i] = array[i - 1] + Integer.parseInt(token.nextToken());
            answer += map.getOrDefault(array[i] - k, 0);
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        System.out.println(answer);
    }
}