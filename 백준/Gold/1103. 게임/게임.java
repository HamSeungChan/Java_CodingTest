import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static int[][] check;
    static boolean[][] route;
    static boolean flag;
    static int n, m;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        array = new int[n][m];
        check = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(check[i], -1);
        }
        route = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (tmp[j].equals("H")) {
                    array[i][j] = -1;
                    continue;
                }
                array[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int result = recursion(0, 0);
        System.out.println(flag ? -1 : result);
    }

    public static int recursion(int x, int y) {

        if (route[x][y]) {
            flag = true;
        }

        if (flag) {
            return Integer.MIN_VALUE;
        }

        if (check[x][y] != -1) {
            return check[x][y];
        }

        int maxValue = 1;

        int value = array[x][y];
        route[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int moveX = x + MOVE_X[i] * value;
            int moveY = y + MOVE_Y[i] * value;

            if (checkRange(moveX, moveY)) {
                maxValue = Math.max(maxValue, recursion(moveX, moveY) + 1);
            }
        }
        route[x][y] = false;
        return check[x][y] = maxValue;
    }

    public static boolean checkRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && array[x][y] != -1;
    }

}
