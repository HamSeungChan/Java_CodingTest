import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array);

        int maxValue = 0;

        for (int i = 0; i < n; i++) {


            int now = array[i];

            if (now <= maxValue || maxValue + 1 == now) {
                maxValue += now;
            } else {
                break;
            }

        }

        System.out.println(maxValue + 1);
    }
}