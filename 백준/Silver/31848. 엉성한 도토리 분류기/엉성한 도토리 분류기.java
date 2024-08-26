import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] check = new int[n + 1];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            int range = Math.min(Integer.parseInt(token.nextToken()) + i - 1, n);
            for (int j = range; j > 0; j--) {
                if (check[j] != 0) {
                    break;
                }
                check[j] = i;
            }
        }

        int q = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(check[Integer.parseInt(token.nextToken())]).append(" ");
        }
        System.out.println(sb);
    }
}