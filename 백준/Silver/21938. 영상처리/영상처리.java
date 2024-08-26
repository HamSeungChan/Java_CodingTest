import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[][] check;
    static float[][] map;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        map = new float[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                float tmp = 0;
                for (int k = 0; k < 3; k++) {
                    tmp += Integer.parseInt(token.nextToken());
                }
                map[i][j] = tmp / 3;
            }
        }

        int value = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] >= value) {
                    map[i][j] = 255;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j] && map[i][j] == 255) {
                    answer++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y) {

        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int moveX = x + MOVE_X[i];
            int moveY = y + MOVE_Y[i];
            if (canMove(moveX, moveY)) {
                dfs(moveX, moveY);
            }
        }
    }

    public static boolean canMove(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && !check[x][y] && map[x][y] == 255;
    }
}