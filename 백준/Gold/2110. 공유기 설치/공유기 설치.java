import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] array;
    static int c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(array);

        long lt = 0;
        long rt = array[array.length - 1];
        long answer = Long.MAX_VALUE;
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

    private static boolean check(long mid) {

        int count = 0;
        long length = array[0] + mid;
        count++;

        for (int i = 1; i < array.length; i++) {

            if (length <= array[i]) {
                length = array[i] + mid;
                count++;
            }
        }
        return count >= c;
    }
}