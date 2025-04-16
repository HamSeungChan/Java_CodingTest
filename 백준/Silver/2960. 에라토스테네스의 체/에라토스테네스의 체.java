import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        solution(n, k);

    }

    public static void solution(int n, int k) {
        int checkCount = 0;
        boolean[] check = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {

            if (check[i]) {
                continue;
            }

            checkCount++;
            check[i] = true;
            if (checkCount == k) {
                System.out.println(i);
                return;
            }

            for (int j = i + i; j <= n; j = j + i) {
                if (check[j]) {
                    continue;
                }
                checkCount++;
                check[j] = true;
                if (checkCount == k) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
