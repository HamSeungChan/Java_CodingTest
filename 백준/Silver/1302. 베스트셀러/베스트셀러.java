import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {

            String tmp = br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        String answer = "";
        int count = -1;
        for (String s : map.keySet()) {
            int value = map.get(s);
            if (value > count) {
                count = value;
                answer = s;
            }
        }
        System.out.println(answer);

    }
}