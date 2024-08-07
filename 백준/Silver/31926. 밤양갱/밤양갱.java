import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 8;
        int size = 1;
        n--;

        while (n > 0) {
            answer += 1;
            n -= size;
            size *= 2;
        }

        System.out.println(answer + (n == 0 ? 2 : 1));

    }
}