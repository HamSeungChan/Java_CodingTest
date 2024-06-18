import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        int max = Integer.MIN_VALUE;
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
            max = Math.max(max, array[i]);
        }

        int lt = 1;
        int rt = max;

        int answer = 0;
        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            if (check(mid)) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean check(int size) {

        for (int i = 0; i <= array.length - size; i++) {

            if (array[i] < size) {
                continue;
            }


            boolean flag = false;
            for (int j = i; j < i + size; j++) {
                if (array[j] < size) {
                    flag = true;
                    i = j;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            return true;
        }
        return false;
    }
}