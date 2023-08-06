import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (c[i] - 'a' + 1) * (int) Math.pow(31, i);
        }
        System.out.println(sum);
    }
}