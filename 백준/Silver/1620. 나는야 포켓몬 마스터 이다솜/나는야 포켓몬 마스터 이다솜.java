import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Map<String, Integer> stringMap = new HashMap<>();
        Map<Integer, String> integerMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            stringMap.put(tmp, i);
            integerMap.put(i, tmp);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            String tmp = br.readLine();

            if (stringMap.containsKey(tmp)) {
                sb.append(stringMap.get(tmp)).append("\n");
            } else {
                sb.append(integerMap.get(Integer.parseInt(tmp))).append("\n");
            }

        }

        System.out.print(sb);
    }
}