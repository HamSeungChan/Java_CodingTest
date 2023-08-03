import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= testCase; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());

            int[][] flySum = new int[n + 1][n + 1];
            for (int i = 1; i < flySum.length; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j < flySum[i].length; j++) {
                    flySum[i][j] = flySum[i][j - 1] + Integer.parseInt(token.nextToken());
                }
            }
            int answer = 0;
            for (int i = m; i < flySum.length; i++) {
                for (int j = m; j < flySum[i].length; j++) {

                    int tmp = 0;
                    for (int k = 0; k < m; k++) {
                        //System.out.println(flySum[i-k][j]+" "+flySum[i-k][j-m]);
                        tmp += flySum[i - k][j] - flySum[i - k][j - m];
                    }
                    answer = Math.max(answer, tmp);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}