import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int index = -1;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            if (array[i] == n) {
                index = i;
            }
        }

        int answer = 0;
        int value = n - 1;
        for (int i = index - 1; i >= 0; i--) {
            if (array[i] != value) {
                answer++;
                continue;
            }
            value -= 1;
        }

        answer += n - index - 1;
        System.out.println(answer);
    }
}