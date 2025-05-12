import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static boolean[][] check;
    static int answer = Integer.MAX_VALUE, n;
    static int[] MOVE_X = {0, 1, 0, -1, 0};
    static int[] MOVE_Y = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        check = new boolean[n][n];

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        recursion(0, 0);
        System.out.println(answer);
    }

    public static void recursion(int depth, int sum) {
        if (depth == 3) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (canUse(i, j)) {
                    int pick = change(i, j);
                    recursion(depth + 1, sum + pick);
                    change(i, j);
                }
            }
        }
    }

    public static int change(int x, int y) {

        int sum = 0;
        for (int k = 0; k < MOVE_X.length; k++) {
            int moveX = x + MOVE_X[k];
            int moveY = y + MOVE_Y[k];

            sum += array[moveX][moveY];
            check[moveX][moveY] = !check[moveX][moveY];
        }

        return sum;
    }

    public static boolean canUse(int x, int y) {

        for (int i = 0; i < MOVE_X.length; i++) {
            int moveX = x + MOVE_X[i];
            int moveY = y + MOVE_Y[i];

            if (check[moveX][moveY]) {
                return false;
            }
        }
        return true;
    }

}
