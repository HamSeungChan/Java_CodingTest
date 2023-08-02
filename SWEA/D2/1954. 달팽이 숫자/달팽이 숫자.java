import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static final int[] MOVE_X = {0, 1, 0, -1};
    static final int[] MOVE_Y = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            StringBuilder sb = new StringBuilder("#").append(t + "\n");
            int n = Integer.parseInt(br.readLine());
            int[][] array = new int[n][n];
            int[][] check = new int[n][n];
            int x = 0;
            int y = 0;
            int direction = 0;
            for (int value = 1; value <= n * n; value++) {
                array[x][y] = value;
                check[x][y] = 1;
                int nextMoveX = x + MOVE_X[direction];
                int nextMoveY = y + MOVE_Y[direction];

                if (nextMoveX < 0 || nextMoveX >= n || nextMoveY < 0 || nextMoveY >= n
                        || check[nextMoveX][nextMoveY] == 1) {
                    direction = (direction + 1) % 4;
                    nextMoveX = x + MOVE_X[direction];
                    nextMoveY = y + MOVE_Y[direction];
                }

                x = nextMoveX;
                y = nextMoveY;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(array[i][j] + " ");
                }
                if (i != n - 1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb);
        }
    }
}