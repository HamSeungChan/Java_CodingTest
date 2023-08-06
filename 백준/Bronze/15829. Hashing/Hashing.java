import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int PRIME = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();

        int sum = 0;
        int pow = 1;
        for (int i = 0; i < n; i++) {
            sum += (c[i] - 'a' + 1) * pow % PRIME;
            pow = (31 * pow) % PRIME;
        }
        System.out.println(sum % PRIME);
    }
}