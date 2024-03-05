import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = br.readLine().toCharArray();

        for (char c : charArray) {
            char newC = Character.toUpperCase(c);
            map.put(newC, map.getOrDefault(newC, 0) + 1);
        }


        int same = 0;
        int maxCount = 0;
        char max = '?';
        for (Character c : map.keySet()) {
            int tmp = map.get(c);
            if (tmp > maxCount) {
                maxCount = tmp;
                max = c;
                same = 0;
            } else if (tmp == maxCount) {
                same++;
            }
        }

        if (same > 0) {
            System.out.println("?");
        } else {
            System.out.println(max);
        }

    }
}