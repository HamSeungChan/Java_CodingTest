import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static int count, r, c;

    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        array = new int[r][c];

        for (int i = 0; i < r; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                array[i][j] = tmp[j] - 'A';
            }
        }

        count = 0;
        dfs(0, 0, new boolean[26], 1);
        System.out.println(count);
    }

    public static void dfs(int r, int c, boolean[] use, int moveCount) {

        use[array[r][c]] = true;
        count = Math.max(moveCount, count);

        for (int i = 0; i < 4; i++) {
            int moveX = r + MOVE_X[i];
            int moveY = c + MOVE_Y[i];

            if (canMove(moveX, moveY, use)) {
                dfs(moveX, moveY, use, moveCount + 1);
            }
        }
        use[array[r][c]] = false;
    }

    public static boolean canMove(int x, int y, boolean[] use) {
        return x >= 0 && x < r && y >= 0 && y < c && !use[array[x][y]];
    }
}