import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(token.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
        int m = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(token.nextToken());
            if(!map.containsKey(tmp)){
                sb.append(0).append(" ");
            }
            else{
                sb.append(map.get(tmp)).append(" ");
            }

        }
        System.out.println(sb);
    }
}