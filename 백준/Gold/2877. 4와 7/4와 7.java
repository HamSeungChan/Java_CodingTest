import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());

        int depth = 1;
        int total = 0;

        do {
            total += (int) Math.pow(2, depth);
            depth += 1;
        } while (total < k);

        for (int i = depth - 1; i >= 1; i--) {

            if (k % 2 == 0) {
                sb.insert(0, 7);
            } else {
                sb.insert(0, 4);
            }

            k = (k % 2 == 0 ? (k / 2 - 1) : k / 2);
        }

        System.out.print(sb);
    }
}
