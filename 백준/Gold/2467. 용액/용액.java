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

        int lt = 0;
        int rt = n - 1;

        int minValue = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        while (lt < rt) {
            int value = array[lt] + array[rt];
            int sum = Math.abs(value);

            if (minValue > sum) {
                minValue = sum;
                a = array[lt];
                b = array[rt];
            }

            if (value > 0) {
                rt--;
            } else if (value < 0) {
                lt++;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" ").append(b);
        System.out.print(sb);
    }
}