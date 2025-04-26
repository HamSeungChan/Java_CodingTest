import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] array = new boolean[123456 * 2 + 1];

        for (int i = 2; i <= Math.sqrt(array.length); i++) {
            if (!array[i]) {
                for (int j = i + i; j < array.length; j += i) {
                    array[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int answer = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if(i == 1) continue;
                if (!array[i]) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
