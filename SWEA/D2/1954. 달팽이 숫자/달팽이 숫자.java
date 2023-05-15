import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        for (int test = 1; test <= testcase; test++) {
            int n = sc.nextInt();
            int i = 0;
            int j = 0;
            int t = 1;
            int bottom = 0;

            int[][] graph = new int[n][n];
            int maxLength = n;

            while (t <= n * n) {
                for (int k = j; k < maxLength; k++) {
                    graph[i][k] = t;
                    t++;
                }
                j = maxLength - 1;

                for (int k = i + 1; k < maxLength; k++) {
                    graph[k][j] = t;
                    t++;
                }
                i = maxLength - 1;

                for (int k = j - 1; k >= bottom; k--) {
                    graph[i][k] = t;
                    t++;
                }
                j = bottom;
                for (int k = i - 1; k > bottom; k--) {
                    graph[k][j] = t;
                    t++;
                }

                maxLength -= 1;
                bottom++;
                i = bottom;
                j = bottom;
            }

            System.out.println("#"+test);
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    System.out.print(graph[k][l] + " ");
                }
                System.out.println();
            }
        }
    }
}
