import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static int[][] check;
    static int n, m;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        map = new String[n][m];
        check = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == 0) {
                    dfs(i, j, count);
                }
            }
        }

        System.out.println(count - 1);
    }


    public static int dfs(int i, int j, int value) {


        String tmp = map[i][j];
        check[i][j] = value;

        int moveX = i;
        int moveY = j;

        if (tmp.equals("D")) {
            moveX += 1;
        } else if (tmp.equals("R")) {
            moveY += 1;
        } else if (tmp.equals("U")) {
            moveX -= 1;
        } else {
            moveY -= 1;
        }

        if (canMove(moveX, moveY)) {
            value = dfs(moveX, moveY, value);
        } else if (check[moveX][moveY] != value) {
            check[i][j] = check[moveX][moveY];
            return check[moveX][moveY];
        } else {
            count++;
        }


        check[i][j] = value;
        return value;
    }

    static boolean canMove(int x, int y) {
        return check[x][y] == 0;
    }
}