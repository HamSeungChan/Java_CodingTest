import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.text.DateFormatSymbols;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static boolean flag = false;
    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        DFS(0, 0, 0);
        System.out.println(answer);
    }

    public static void DFS(int sum, int count, int start) {

        if (flag) {
            return;
        }

        if (sum > m) {
            return;
        }

        if (sum == m && count == 3) {
            flag = true;
            answer = sum;
            return;
        }

        if (count == 3) {
            answer = Math.max(answer, sum);
        } else {
            for (int i = start; i < n; i++) {
                sum += array[i];
                DFS(sum, count + 1, i + 1);
                sum -= array[i];
            }
        }
    }
}