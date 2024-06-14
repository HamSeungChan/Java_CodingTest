import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        array = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            array[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, array[i]);
        }

        int lt = 1;
        int rt = max;
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (check(mid)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean check(int mid) {

        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp += array[i] / mid;
            if (array[i] % mid > 0) {
                tmp++;
            }
        }

        if (tmp > n) {
            return false;
        }
        return true;
    }

}