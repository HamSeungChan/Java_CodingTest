import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, answer = 0;
    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        recursion(0, 0, new boolean[n]);
        System.out.println(answer);
    }

    public static void recursion(int sum, int count, boolean[] check) {

        if (count == n - 2) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 1; i <= n - 2; i++) {

            if (check[i]) {
                continue;
            }

            check[i] = true;
            int left = 0;
            int right = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (!check[j]) {
                    left = array[j];
                    break;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (!check[j]) {
                    right = array[j];
                    break;
                }
            }

            recursion(sum + left * right, count + 1, check);

            check[i] = false;
        }
    }
}