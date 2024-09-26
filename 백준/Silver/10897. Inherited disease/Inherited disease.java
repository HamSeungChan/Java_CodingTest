import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int mod = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        long numberCount = 0;
        long currentNumber = 1;
        long node = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= D; i++) {

            int d = Integer.parseInt(token.nextToken());
            currentNumber = ((currentNumber - 1) * i + d) % mod;

            sb.append((numberCount + currentNumber) % mod).append("\n");
            node = (node * i) % mod;
            numberCount = (numberCount + node) % mod;

        }
        System.out.println(sb);
    }
}