import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] array = br.readLine().toCharArray();
        int answer = 0;

        int lt = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int rt = 0; rt < array.length; rt++) {
            map.put(array[rt], map.getOrDefault(array[rt], 0) + 1);
            while (map.size() > n) {
                lt++;
                int tmp = map.get(array[lt]) - 1;
                if (tmp == 0) {
                    map.remove(array[lt]);
                    break;
                }
                map.put(array[lt], tmp);
            }
            answer = Math.max(answer, rt - lt);
        }
        System.out.println(answer);
    }
}