import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int value = 0;

        int lt = 1;
        for (int rt = 1; rt <= n; rt++) {

            value += rt;

            while (value > n) {
                value -= lt;
                lt++;
            }

            if (value == n) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}