import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] array = new long[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(token.nextToken());
        }

        Arrays.sort(array);

        long a = 0, b = 0, c = 0;
        StringBuilder answer = new StringBuilder();
        long minValue = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int lt = j + 1;
                int rt = n - 1;

                while (lt <= rt) {

                    int midIndex = (lt + rt) / 2;
                    long sum = array[i] + array[j] + array[midIndex];

                    if (minValue > Math.abs(sum)) {
                        a = array[i];
                        b = array[j];
                        c = array[midIndex];
                        minValue = Math.abs(sum);
                    }

                    if (sum > 0) {
                        rt = midIndex - 1;
                    } else if (sum < 0) {
                        lt = midIndex + 1;
                    } else {
                        break;
                    }
                }
            }
        }

        answer.append(a).append(" ").append(b).append(" ").append(c);
        System.out.print(answer);
    }
}