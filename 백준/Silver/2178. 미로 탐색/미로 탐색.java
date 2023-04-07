
import java.util.LinkedList;
import java.util.Queue;
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

    private static final int[] mX = {1, 0, -1, 0};
    private static final int[] mY = {0, 1, 0, -1};
    private static final int mazeStart = 1;

    static int n;
    static int m;
    static char[][] graph;
    static int[][] distance;
    static char[][] checkGraph;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        distance = new int[n + 1][m + 1];
        graph = new char[n + 1][m + 1];
        checkGraph = new char[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {
            char[] c = sc.next().toCharArray();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = c[j - 1];
            }
        }

        // 시간초과
        // new Main().DFS(1, 1, 1);
        new Main().BFS(mazeStart,mazeStart);
        System.out.print(distance[n][m]);
    }


    void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        graph[x][y] = '0';
        distance[x][y] = 1;

        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < mX.length; i++) {
                int moveX = tmp.x + mX[i];
                int moveY = tmp.y + mY[i];
                if (mazeStart <= moveX && moveX <= n && mazeStart <= moveY && moveY <= m && graph[moveX][moveY] == '1') {
                    q.offer(new Point(moveX, moveY));
                    graph[moveX][moveY] = '0';
                    distance[moveX][moveY] = distance[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    void DFS(int x, int y, int count) {

        if (count > answer) return;

        if (x == n && y == m) {
            answer = Math.min(answer, count);
        } else {
            for (int i = 0; i < mX.length; i++) {
                if (graph[x + mX[i]][y + mY[i]] == '1' && checkGraph[x + mX[i]][y + mY[i]] == 0) {
                    checkGraph[x + mX[i]][y + mY[i]] = 1;
                    DFS(x + mX[i], y + mY[i], count + 1);
                    checkGraph[x + mX[i]][y + mY[i]] = 0;
                }
            }
        }
    }
}
