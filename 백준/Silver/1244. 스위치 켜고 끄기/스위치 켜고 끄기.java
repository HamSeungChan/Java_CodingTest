import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n + 1];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int i = Integer.parseInt(br.readLine());
        for (int j = 0; j < i; j++) {

            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            // 남학생은 1
            // 여학생은 2

            if (a == 1) {
                for (int k = b; k <= n; k += b) {
                    change(array, k);
                }
                continue;
            }

            change(array, b);
            int left = b;
            int right = b;

            while (left >= 1 && right <= n && array[left] == array[right]) {
                change(array, left);
                change(array, right);
                left--;
                right++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= n; k++) {
            sb.append(array[k]).append(" ");
            if (k % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void change(int[] array, int index) {

        if (array[index] == 1) {
            array[index] = 0;
            return;
        }
        array[index] = 1;
    }

}




