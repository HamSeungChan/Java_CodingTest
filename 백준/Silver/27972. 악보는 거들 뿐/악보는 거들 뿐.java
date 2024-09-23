import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int increase = 1;
        int decrease = 1;
        int answer = 1;

        for (int i = 1; i < n; i++) {
            if (array[i - 1] < array[i]) {
                increase += 1;
                decrease = 1;
            } else if (array[i - 1] > array[i]) {
                decrease += 1;
                increase = 1;
            }
            answer = Math.max(answer, Math.max(increase, decrease));
        }
        System.out.println(answer);
    }

}