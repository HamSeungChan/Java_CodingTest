import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] array = new boolean[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken()) == 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i]) {
                for (int j = 1; j <= 2; j++) {
                    if (i + j < n) {
                        array[i + j] = !array[i + j];
                    }
                }
                count++;
            }
        }

        System.out.println(count);
    }

}