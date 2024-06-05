import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(array);
        int x = Integer.parseInt(br.readLine());

        int lt = 0;
        int rt = n - 1;

        int answer = 0;
        while (lt < rt) {
            if (array[lt] + array[rt] > x) {
                rt--;
            } else if (array[lt] + array[rt] < x) {
                lt++;
            } else {
                answer++;
                lt++;
            }
        }
        System.out.println(answer);
    }
}