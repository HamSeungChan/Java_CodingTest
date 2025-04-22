import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(br.readLine());
        long x = Long.parseLong(br.readLine());

        System.out.println(recursion(a % MOD, x));
    }

    public static long recursion(long a, long x) {

        if (x == 0) {
            return 1;
        }

        if (x == 1) {
            return a % MOD;
        }

        long value = recursion(a, x / 2);
        long result = (value * value) % MOD;

        // 홀수
        if (x % 2 == 1) {
            return (result * a) % MOD;
        }

        // 짝수
        return result;
    }
}
