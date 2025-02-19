import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, answer = Integer.MIN_VALUE;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        map = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        recursion(0, 0, 0, 0);
        System.out.println(answer);
    }

    public static void recursion(int x, int y, int pickCount, int sum) {

        if (pickCount == k) {
            answer = Math.max(sum, answer);
            return;
        }

        if (y == m) {
            x++;
            y = 0;
        }

        if (x == n) {
            return;
        }

        // 선택한다.
        if (canPick(x, y)) {
            check[x][y] = true;
            recursion(x, y + 1, pickCount + 1, sum + map[x][y]);
            check[x][y] = false;
        }

        // 선택하지 않는다.
        recursion(x, y + 1, pickCount, sum);
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canPick(int x, int y) {

        for (int i = 0; i < MOVE_X.length; i++) {
            int moveX = x + MOVE_X[i];
            int moveY = y + MOVE_Y[i];

            if (inRange(moveX, moveY) && check[moveX][moveY]) {
                return false;
            }
        }

        return true;
    }

}