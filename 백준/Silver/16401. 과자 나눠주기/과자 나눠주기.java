import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());

        array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int lt = 1;
        int rt = 1000000000;
        int answer = 0;

        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            if (check(mid)) {
                answer = mid;
                lt = mid + 1;
                continue;
            }
            rt = mid - 1;
        }

        System.out.println(answer);

    }

    public static boolean check(int value) {

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= value) {
                count += array[i] / value;
            }
        }

        if (count < m) {
            return false;
        }

        return true;
    }

}