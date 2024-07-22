import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, -1, 0, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = new int[5][5];

        StringTokenizer token;
        for (int i = 0; i < 5; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(token.nextToken());
        int startY = Integer.parseInt(token.nextToken());

        dfs(startX, startY, 0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void dfs(int x, int y, int depth, int moveCount) {

        if (array[x][y] == 1) {
            depth++;
        }

        if (depth == 3) {
            answer = Math.min(answer, moveCount);
            return;
        }

        int before = array[x][y];
        array[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            int moveX = x + MOVE_X[i];
            int moveY = y + MOVE_Y[i];
            if (canMove(moveX, moveY)) {
                dfs(moveX, moveY, depth, moveCount + 1);
            }
        }

        array[x][y] = before;
    }

    public static boolean canMove(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5 && array[x][y] != -1;
    }

}