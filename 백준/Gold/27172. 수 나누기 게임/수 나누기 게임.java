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

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
            map.put(array[i], 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = array[i] + array[i]; j <= 1000000; j += array[i]) {
                if (map.containsKey(j)) {
                    map.put(array[i], map.get(array[i]) + 1);
                    map.put(j, map.get(j) - 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int now : array) {
            sb.append(map.get(now)).append(" ");
        }
        System.out.print(sb);
    }
}