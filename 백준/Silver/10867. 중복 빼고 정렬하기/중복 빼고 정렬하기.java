import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(token.nextToken());
            if (!list.contains(tmp)) {
                list.add(tmp);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}