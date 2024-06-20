import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());
        int l = Integer.parseInt(token.nextToken());

        int[] array = new int[m];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            int lt = 0;
            int rt = m - 1;
            while (lt <= rt) {

                int mid = (lt + rt) / 2;
                int value = Math.abs(a - array[mid]) + b;
                if (value <= l) {
                    answer++;
                    break;
                }

                if (array[mid] <= a) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
        }
        System.out.println(answer);
    }
}