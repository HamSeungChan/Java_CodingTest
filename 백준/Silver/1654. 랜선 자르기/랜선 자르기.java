import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());

        long[] array = new long[k];

        long lt = 1;
        long rt = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
            rt = Math.max(rt, array[i]);
        }

        while (lt <= rt) {

            long middle = (lt + rt) / 2;
            long sum = 0;
            for (long x : array) {
                sum += x / middle;
            }

            if (sum >= n) {
                lt = middle + 1;
            } else {
                rt = middle - 1;
            }
        }

        System.out.println((lt+rt)/2);

    }
}