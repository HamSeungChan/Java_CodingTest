import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c, k, count;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, -1, 0, 1};
    static boolean[][] map;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        map = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (tmp[j] == '.') {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }

        boolean[][] check = new boolean[r][c];
        check[r - 1][0] = true;
        dfs(r - 1, 0, 1, check);

        System.out.println(count);


    }

    public static void dfs(int x, int y, int depth, boolean[][] check) {


        if (depth > k) {
            return;
        }

        if (x == 0 && y == c - 1) {
            if (depth == k) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {

            int moveX = x + MOVE_X[i];
            int moveY = y + MOVE_Y[i];

            if (inRange(moveX, moveY) && !check[moveX][moveY] && map[moveX][moveY]) {
                check[moveX][moveY] = true;
                dfs(moveX, moveY, depth + 1, check);
                check[moveX][moveY] = false;
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }
}
