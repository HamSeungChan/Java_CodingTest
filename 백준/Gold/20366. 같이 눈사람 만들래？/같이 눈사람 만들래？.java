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

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {

                int sum = array[i] + array[j];
                int lt = i + 1;
                int rt = j - 1;
                while (lt < rt) {
                    int tmp = array[lt] + array[rt];
                    answer = Math.min(answer, Math.abs(sum - tmp));
                    if (sum == tmp) {
                        break;
                    } else if (sum < tmp) {
                        rt--;
                    } else {
                        lt++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}