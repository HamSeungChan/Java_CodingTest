import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        permutation(0, 0, new int[n], new boolean[n]);
        System.out.println(answer);

    }

    public static void permutation(int index, int totalCount, int[] per, boolean[] check) {

        if (totalCount == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(per[i] - per[i + 1]);
            }
            answer = Math.max(sum, answer);
        } else {
            for (int i = 0; i < array.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    per[index] = array[i];
                    permutation(index + 1, totalCount + 1, per, check);
                    check[i] = false;
                }

            }
        }
    }
}