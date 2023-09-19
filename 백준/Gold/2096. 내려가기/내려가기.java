import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] maxArray = new int[n + 1][3];
        int[][] minArray = new int[n + 1][3];

        int[][] array = new int[n + 1][3];
        StringTokenizer token;
        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {

            maxArray[i][0] = Math.max(maxArray[i - 1][0], maxArray[i - 1][1]) + array[i][0];
            maxArray[i][1] = Math.max(maxArray[i - 1][2], Math.max(maxArray[i - 1][0], maxArray[i - 1][1])) + array[i][1];
            maxArray[i][2] = Math.max(maxArray[i - 1][1], maxArray[i - 1][2]) + array[i][2];

            minArray[i][0] = Math.min(minArray[i - 1][0], minArray[i - 1][1]) + array[i][0];
            minArray[i][1] = Math.min(minArray[i - 1][2], Math.min(minArray[i - 1][0], minArray[i - 1][1])) + array[i][1];
            minArray[i][2] = Math.min(minArray[i - 1][1], minArray[i - 1][2]) + array[i][2];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(maxArray[n][2], Math.max(maxArray[n][0], maxArray[n][1]))).append(" ");
        sb.append(Math.min(minArray[n][2], Math.min(minArray[n][0], minArray[n][1])));
        System.out.print(sb);

    }
}