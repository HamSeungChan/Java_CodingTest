import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int[] array = new int[n];
        int k = Integer.parseInt(token.nextToken());

        int lionCount = 0;
        int answer = Integer.MAX_VALUE;

        token = new StringTokenizer(br.readLine(), " ");
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {

            int tmp = Integer.parseInt(token.nextToken());
            array[rt] = tmp;

            if (tmp == 1) {
                lionCount++;
            }

            if (lionCount == k) {
                while (array[lt] != 1) {
                    lt++;
                }
                answer = Math.min(answer, rt - lt + 1);
                lt++;
                lionCount--;
            }

        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}