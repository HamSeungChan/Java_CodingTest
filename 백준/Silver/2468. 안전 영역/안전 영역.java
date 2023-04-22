
import java.util.Scanner;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static final int[] MOVE_X = {0, 1, 0, -1};
    static final int[] MOVE_Y = {1, 0, -1, -0};
    static int n;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        graph = new int[n][n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = sc.nextInt();
                max = Math.max(max, k);
                min = Math.min(min, k);
                graph[i][j] = k;
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int rain = min-1; rain < max; rain++) {
            int safeZoneCount = 0;
            int[][] checkGraph = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > rain && checkGraph[i][j] == 0) {
                        safeZoneCount++;
                        DFS(checkGraph, new Point(i, j), rain);
                    }
                }
            }
            answer = Math.max(safeZoneCount, answer);
        }
        System.out.println(answer);
    }

    static void DFS(int[][] checkGraph, Point p, int rainValue) {

        checkGraph[p.x][p.y] = 1;

        for (int i = 0; i < MOVE_X.length; i++) {
            int mX = p.x + MOVE_X[i];
            int mY = p.y + MOVE_Y[i];
            if (mX >= 0 && mX < n && mY >= 0 && mY < n && graph[mX][mY] > rainValue && checkGraph[mX][mY] == 0) {
                DFS(checkGraph, new Point(mX, mY), rainValue);
            }
        }
    }
}
