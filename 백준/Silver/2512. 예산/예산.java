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
        int max = 0;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
            max = Math.max(max, array[i]);
        }

        int m = Integer.parseInt(br.readLine());

        int lt = 0;
        int rt = max;
        int answer = -1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (solution(mid, m, array)) {
                answer = Math.max(answer, mid);
                lt = mid + 1;
                continue;
            }
            rt = mid - 1;
        }

        System.out.println(answer);
    }

    public static boolean solution(int value, int m, int[] array) {

        int total = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= value) {
                total += array[i];
            } else {
                total += value;
            }

            if (total > m) {
                return false;
            }
        }
        return true;
    }
}
