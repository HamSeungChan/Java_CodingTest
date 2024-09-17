import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());

        int[][] array = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            Arrays.fill(array[i], 100_000_000);
            array[i][i] = 0;
        }


        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            array[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())]
                    = Integer.parseInt(token.nextToken());
        }

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    array[i][j] = Math.min(array[i][j], array[i][k] + array[k][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            for (int j = i + 1; j <= v; j++) {
                if (array[i][j] == 100_000_000 || array[j][i] == 100_000_000) {
                    continue;
                }
                answer = Math.min(answer, array[i][j] + array[j][i]);
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}