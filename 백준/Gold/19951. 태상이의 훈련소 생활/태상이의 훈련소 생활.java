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

        int[] array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int[] sumArray = new int[n + 1];

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(token.nextToken()) - 1;
            int end = Integer.parseInt(token.nextToken()) - 1;
            int value = Integer.parseInt(token.nextToken());


            sumArray[start] += value;
            sumArray[end + 1] += (value * -1);
        }

        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += sumArray[i];
            sb.append(array[i] + tmp).append(" ");
        }
        System.out.print(sb);
    }
}