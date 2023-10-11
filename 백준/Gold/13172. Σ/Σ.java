import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer token;
        long answer = 0;
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            long n = Integer.parseInt(token.nextToken());
            long s = Integer.parseInt(token.nextToken());
            answer = (answer + (s * pow(n, div - 2)) % div) % div;
        }
        System.out.println(answer);
    }

    private static long pow(long a, long b) {
        long answer = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                answer = (answer * a) % div;
                b--;
            }
            a = (a * a) % div;
            b /= 2;
        }
        return answer;
    }

}