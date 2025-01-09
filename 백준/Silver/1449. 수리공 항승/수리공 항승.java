import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int l = Integer.parseInt(token.nextToken());

        int[] array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array);
        int last = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (last <= array[i]) {

                last = array[i] + l;
                answer++;
            }
        }

        System.out.println(answer);
    }
}