import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(token.nextToken());
        int l = Integer.parseInt(token.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String number = br.readLine();
            map.put(number, i);
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.comparingInt(map::get));

        StringBuilder sb = new StringBuilder();
        int range = Math.min(k, list.size());
        for (int i = 0; i < range; i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.print(sb);
    }
}