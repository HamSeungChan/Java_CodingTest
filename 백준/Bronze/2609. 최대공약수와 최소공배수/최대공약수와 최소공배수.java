import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        int min = Math.min(a, b);
        int x = 1;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                x = i;
            }
        }
        int y = a * b;
        if (x != 1) {
            for (int i = x; i <= y; i += x) {
                if (i % a == 0 && i % b == 0) {
                    y = i;
                    break;
                }
            }
        }

        System.out.println(x);
        System.out.println(y);

    }
}