import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[] array = new int[m];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[j] += Integer.parseInt(token.nextToken());
            }
        }

        int size = Integer.parseInt(br.readLine());
        int answer = 0;
        int value = 0;
        int lt = 0;
        for (int rt = 0; rt < m; rt++) {
            value += array[rt];
            if (rt - lt + 1 == size) {
                answer = Math.max(value, answer);
                value -= array[lt];
                lt++;
            }
        }
        System.out.println(answer);
    }
}