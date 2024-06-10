import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        boolean[] array = new boolean[n + 1];
        for (int i = 0; i < b; i++) {
            int tmp = Integer.parseInt(br.readLine());
            array[tmp] = true;
        }

        int lt = 1;
        int rt = 1;
        int count = 0;
        for (; rt <= k; rt++) {
            if (array[rt]) {
                count++;
            }
        }

        int answer = count;
        for (; rt <= n; rt++) {
            if (array[lt++]) {
                count--;
            }

            if (array[rt]) {
                count++;
            }
            answer = Math.min(answer, count);
        }
        System.out.println(answer);
    }
}