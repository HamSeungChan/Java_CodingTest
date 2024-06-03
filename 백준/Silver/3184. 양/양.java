import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c, sheepCount, wolfCount, totalSheepCount, totalWolfCount;
    static char[][] array;
    static boolean[][] visited;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        array = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            array[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && array[i][j] != '#') {
                    sheepCount = 0;
                    wolfCount = 0;
                    visited[i][j] = true;
                    dfs(i, j);
                    if (sheepCount > wolfCount) {
                        totalSheepCount += sheepCount;
                    } else {
                        totalWolfCount += wolfCount;
                    }
                }
            }
        }
        System.out.println(totalSheepCount + " " + totalWolfCount);
    }

    public static void dfs(int x, int y) {

        if (array[x][y] == 'o') {
            sheepCount++;
        } else if (array[x][y] == 'v') {
            wolfCount++;
        }

        for (int i = 0; i < 4; i++) {
            int moveX = x + MOVE_X[i];
            int moveY = y + MOVE_Y[i];
            if (canMove(moveX, moveY)) {
                visited[moveX][moveY] = true;
                dfs(moveX, moveY);
            }
        }
    }

    public static boolean canMove(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c && !visited[x][y] && array[x][y] != '#';
    }

}