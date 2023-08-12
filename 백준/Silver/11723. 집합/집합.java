import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            String tmp = token.nextToken();

            if (tmp.equals("add")) {
                set.add(token.nextToken());
            } else if (tmp.equals("check")) {
                if (set.contains(token.nextToken())) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (tmp.equals("remove")) {
                set.remove(token.nextToken());
            } else if (tmp.equals("toggle")) {
                String value = token.nextToken();
                if (set.contains(value)) {
                    set.remove(value);
                } else {
                    set.add(value);
                }
            } else if (tmp.equals("all")) {
                for(int j = 1 ; j<= 20; j++){
                    set.add(String.valueOf(j));
                }
            } else {
                set.clear();
            }
        }
        System.out.println(sb);
    }
}