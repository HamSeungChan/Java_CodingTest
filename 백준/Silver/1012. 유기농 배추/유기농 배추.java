import java.util.Scanner;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private final int[] MOVE_X = {0, 1, 0, -1};
    private final int[] MOVE_Y = {1, 0, -1, 0};
    static int n;
    static int m;

    public void DFS(int x, int y, int [][] graph) {
        graph[x][y] = 0;
        for (int i = 0; i < MOVE_X.length; i++) {
            int mX = x + MOVE_X[i];
            int mY = y + MOVE_Y[i];
            if(0<=mX && mX<n && 0<=mY && mY<m && graph[mX][mY] == 1){
                DFS(mX,mY,graph);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int t = 0; t < test; t++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            int answer = 0;

            int[][] graph = new int[n][m];

            for (int i = 0; i < k; i++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                graph[x][y] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 1) {
                        answer++;
                        new Main().DFS(i, j,graph);
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
