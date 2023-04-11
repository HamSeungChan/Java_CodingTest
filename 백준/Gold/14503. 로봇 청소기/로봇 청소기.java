import java.util.Scanner;

public class Main {

    private static final int[] MOVE_X = {-1, 0, 1, 0};
    private static final int[] MOVE_Y = {0, 1, 0, -1};
    private static final int NUMBER_OF_MOVE = 4;
    private static final int NOT_CLEAN = 0;
    private static final int CLEAN = 2;
    private static final int WALL = 1;


    static int[][] graph;
    static int n;
    static int m;
    static int cleanCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];
        int x = sc.nextInt();
        int y = sc.nextInt();
        int direction = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        new Main().clean(x, y, direction);
        System.out.println(cleanCount);
    }

    public void clean(int x, int y, int direction) {
        if (graph[x][y] == NOT_CLEAN) {
            graph[x][y] = CLEAN;
            cleanCount++;
            //System.out.println(cleanCount);

        }
        for (int i = 0; i < NUMBER_OF_MOVE; i++) {
            direction = (direction - 1 + 4) % 4;
            int mX = x + MOVE_X[direction];
            int mY = y + MOVE_Y[direction];
            if (0 <= mX && mX < n && 0 <= mY && mY < m && graph[mX][mY] == NOT_CLEAN) {
                clean(mX, mY, direction);
                return;
            }
        }

        int mX = x - MOVE_X[direction];
        int mY = y - MOVE_Y[direction];
        if (0 <= mX && mX < n && 0 <= mY && mY < m && graph[mX][mY] != WALL) {
            clean(mX, mY, direction);
        }
        //System.out.println(cleanCount);
    }
}

