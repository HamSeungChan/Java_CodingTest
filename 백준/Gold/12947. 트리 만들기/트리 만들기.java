import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            cnt[i] = Integer.parseInt(token.nextToken());
        }

        int left = 0;
        int right = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {

            if (cnt[i] != 1) {
                left += 1;
                right += 1;
            } else {
                left = 0;
                right = 0;
            }
            answer = Math.max(answer + 1, left + right);
        }
        System.out.println(answer);
    }
}