import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i <= n - m; i++) {
                for(int j =0; j<= n-m;j++) {
                    int count = 0;
                    for (int l = i; l < i + m; l++) {
                        for (int k = j; k < j + m; k++) {
                            count += map[l][k];
                        }
                    }
                    if (count > answer) {
                        answer = count;
                    }
                }
            }
            System.out.println("#" + (t + 1) + " " + answer);
        }
    }
}
