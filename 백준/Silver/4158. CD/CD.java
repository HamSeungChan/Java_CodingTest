import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        while (true) {
            token = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            int answer = 0;
            for (int i = 0; i < m; i++) {
                if (set.contains(Integer.parseInt(br.readLine()))) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
