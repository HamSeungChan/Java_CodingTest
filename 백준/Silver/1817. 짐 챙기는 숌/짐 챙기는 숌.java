import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        if (n == 0) {
            System.out.println(0);
        } else {
            int[] array = new int[n];
            token = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(token.nextToken());
            }

            int answer = 0;
            int emptySpace = 0;
            for (int i : array) {
                if (emptySpace < i) {
                    answer++;
                    emptySpace = m - i;
                    continue;
                }
                emptySpace -= i;
            }
            System.out.println(answer);
        }
    }
}