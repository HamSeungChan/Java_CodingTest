import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int index = 0;
        int[] array = new int[n * 2];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(token.nextToken());

            for (int j = 0; j < k; j++) {

                int value = Integer.parseInt(token.nextToken());

                if (j == 0) {
                    array[index++] = value;
                } else if (j == k - 1) {
                    array[index++] = value;
                }
            }
        }

        Arrays.sort(array);
        System.out.println(array[n - 1]);

    }
}
