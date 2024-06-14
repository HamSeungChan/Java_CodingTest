import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] array;
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        array = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            max = Math.max(array[i], max);
        }

        long lt = 1;
        long rt = max;
        long answer = 0;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (check(mid)) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean check(long value) {

        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp += array[i] / value;
        }

        return tmp >= k;
    }
}