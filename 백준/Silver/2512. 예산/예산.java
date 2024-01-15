import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        array = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int lt = 0;
        int rt = array[n - 1];

        int answer = 0;
        while (lt <= rt) {
            int middle = (lt + rt) / 2;
            int sum = sum(middle);

            if (sum > m) {
                rt = middle - 1;
            } else {
                answer = Math.max(middle, answer);
                lt = middle + 1;
            }
        }
        System.out.println(answer);
    }

    public static int sum(int middle) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > middle) {
                sum += middle;
            } else {
                sum += array[i];
            }
        }
        return sum;
    }
}