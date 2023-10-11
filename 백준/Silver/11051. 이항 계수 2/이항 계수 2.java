import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int DIV = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        // 분자
        int number = factorial(n);

        // 분모
        int bunmo = (factorial(k) * factorial(n - k)) % DIV;
        System.out.println((number * mod_inverse(bunmo, DIV - 2)) % DIV);
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return (n * factorial(n - 1)) % DIV;
    }

    // 역원 구하기
    public static int mod_inverse(int a, int p) {
        int ret = 1;
        while (p > 0) {
            if (p % 2 == 1) {
                ret *= a;
                p--;
                ret %= DIV;
            }
            a *= a;
            a %= DIV;
            p >>= 1;
        }
        return ret;
    }

}