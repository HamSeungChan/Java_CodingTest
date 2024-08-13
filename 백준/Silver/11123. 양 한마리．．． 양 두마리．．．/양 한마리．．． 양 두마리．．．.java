import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int h, w;
    static int[][] map;
    static boolean[][] check;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            token = new StringTokenizer(br.readLine(), " ");
            h = Integer.parseInt(token.nextToken());
            w = Integer.parseInt(token.nextToken());

            map = new int[h][w];
            check = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < w; j++) {
                    if (tmp.charAt(j) == '#') {
                        map[i][j] = 1;  // 양
                        continue;
                    }
                    map[i][j] = 0;  // 풀
                }
            }

            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !check[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
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
        return 0 <= x && x < h && 0 <= y && y < w && !check[x][y] && map[x][y] == 1;
    }
}