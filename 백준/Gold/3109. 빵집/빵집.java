import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c, answer = 0;
    static boolean flag;
    static char[][] map;
    static boolean[][] use;
    static int[] MOVE_X = {-1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        map = new char[r][c];
        use = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            flag = false;
            setPipe(i, 0);
        }
        System.out.println(answer);
    }

    public static void setPipe(int x, int y) {

        use[x][y] = true;

        if (y == c - 1) {
            flag = true;
            answer++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int moveX = x + MOVE_X[i];
            if (canMove(moveX, y + 1)) {
                setPipe(moveX, y + 1);
                if (flag) {
                    return;
                }
            }
        }
    }

    public static boolean canMove(int x, int y) {
        return 0 <= x && x < r && !use[x][y] && map[x][y] != 'x';
    }
}