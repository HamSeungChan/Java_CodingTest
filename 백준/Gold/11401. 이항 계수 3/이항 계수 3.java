import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final long DIV = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            long n = Long.parseLong(token.nextToken());
            long k = Long.parseLong(token.nextToken());

            long top = factorial(n);
            long bottom = (factorial(k) * factorial(n - k)) % DIV;
         System.out.println((top * pow(bottom, DIV - 2) % DIV) % DIV);
           
     
    }

    public static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }
        return (n * factorial(n - 1)) % DIV;
    }

    public static long pow(long base, long expo) {

        long result = 1;
        while (expo > 0) {
            if (expo % 2 == 1) {
                result = (result * base) % DIV;
                expo--;
            }
            base = (base * base) % DIV;
            expo /= 2;
        }
        return result;
    }

}