import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n * 3];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n * 3; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array);

        System.out.println(array[2 * n - 1] - array[n]);

    }
}
