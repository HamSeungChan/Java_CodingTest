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
        int[][] array = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1] - array[i - 1][j - 1] + Integer.parseInt(token.nextToken());
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= i; l++) {
                    for (int k = 1; k <= j; k++) {
                        answer = Math.max(answer, array[i][j] - array[i - l][j] - array[i][j - k] + array[i - l][j - k]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}