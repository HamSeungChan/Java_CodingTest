import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(token.nextToken());
            int lt = 0;
            int rt = n - 1;
            int answer = 0;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;

                if (array[mid] > tmp) {
                    rt = mid - 1;
                } else if (array[mid] < tmp) {
                    lt = mid + 1;
                } else {
                    answer = 1;
                    break;
                }
            }
            sb.append(answer).append(" ");
        }
        System.out.print(sb);
    }
}