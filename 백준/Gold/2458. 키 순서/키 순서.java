import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        boolean[][] highArray = new boolean[n + 1][n + 1];
        boolean[][] lowArray = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            highArray[a][b] = true;
            lowArray[b][a] = true;
        }


        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] check = new boolean[n + 1];
            count = 0;
            find(highArray, i, check);
            find(lowArray, i, check);

            if (count == n - 1) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static void find(boolean[][] array, int cur, boolean[] check) {
        check[cur] = true;
        for (int i = 1; i <= n; i++) {
            if (array[cur][i] && !check[i]) {
                count++;
                find(array, i, check);
            }
        }
    }
}