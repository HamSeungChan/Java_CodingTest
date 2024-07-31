import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n + 1];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {

            int value = Integer.parseInt(token.nextToken());
            int emptySpace = 0;
            for (int j = 0; j < n; j++) {
                if (emptySpace == value) {
                    while (answer[j] != 0) {
                        j++;
                    }
                    answer[j] = i;
                    break;
                }

                if (answer[j] == 0) {
                    emptySpace++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb);
    }
}