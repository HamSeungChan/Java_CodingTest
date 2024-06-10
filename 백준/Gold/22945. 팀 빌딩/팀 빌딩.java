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

        int lt = 1;
        int rt = n;

        int answer = Integer.MIN_VALUE;
        while (lt < rt) {
            answer = Math.max(answer, (rt - lt - 1) * Math.min(array[lt], array[rt]));
            if (array[lt] <= array[rt]) {
                lt++;
            } else {
                rt--;
            }
        }
        System.out.println(answer);
    }
}