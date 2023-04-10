import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private static final int[] moveDirectionX = {1, 0, -1, 0};
    private static final int[] moveDirectionY = {0, 1, 0, -1};
    private static final int numberDirectionMovement = 4;

    static int n;
    static int m;
    static int[][] graph;
    static int[][] distance;
    static Queue<Point> q = new LinkedList<>();

    public void BFS() {


        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < numberDirectionMovement; i++) {
                int mX = tmp.x + moveDirectionX[i];
                int mY = tmp.y + moveDirectionY[i];
                if (0 <= mX && mX < n && 0 <= mY && mY < m && graph[mX][mY] == 0) {
                    distance[mX][mY] = distance[tmp.x][tmp.y] + 1;
                    graph[mX][mY] = 1;
                    q.offer(new Point(mX, mY));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        graph = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }

        new Main().BFS();
        boolean flag = true;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) flag = false;
            }
        }

        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(distance[i][j], answer);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}