import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[][] sumArray = new int[n + 1][n + 1];
        for (int i = 1; i < sumArray.length; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < sumArray.length; j++) {
                sumArray[i][j] = sumArray[i - 1][j] + sumArray[i][j - 1] - sumArray[i - 1][j - 1] + Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(token.nextToken());
            int startY = Integer.parseInt(token.nextToken());
            int endX = Integer.parseInt(token.nextToken());
            int endY = Integer.parseInt(token.nextToken());

            int answer = sumArray[endX][endY]
                    - sumArray[endX][startY-1]
                    - sumArray[startX-1][endY]
                    + sumArray[startX - 1][startY - 1];

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

}