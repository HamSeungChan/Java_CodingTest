import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[] arrayA = new int[n];
        int[] arrayB = new int[m];

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arrayB[i] = Integer.parseInt(token.nextToken());
        }

        int[] answer = new int[n + m];
        int a = 0, b = 0;
        for (int i = 0; i < answer.length; i++) {

            if (a == n) {
                answer[i] = arrayB[b];
                b++;
            } else if (b == m) {
                answer[i] = arrayA[a];
                a++;
            } else {
                if (arrayA[a] < arrayB[b]) {
                    answer[i] = arrayA[a];
                    a++;
                } else {
                    answer[i] = arrayB[b];
                    b++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}