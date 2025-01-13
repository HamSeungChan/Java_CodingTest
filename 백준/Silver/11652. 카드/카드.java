import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {

            long value = Long.parseLong(br.readLine());
            map.put(value, map.getOrDefault(value, 0) + 1);

        }


        long answer = 0;
        int maxCount = 0;

        for (Long key : map.keySet()) {
            int count = map.get(key);
            if (maxCount < count) {
                answer = key;
                maxCount = count;
            }
        }
        System.out.println(answer);
    }
}