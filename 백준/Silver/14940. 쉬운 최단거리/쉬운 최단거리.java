import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};

    static int n;
    static int m;
    static int[][] array;
    static int[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n][m];
        check = new int[n][m];
        Point p = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2) {
                    p = new Point(i, j);
                }
                array[i][j] = tmp;
            }
        }

        BFS(p);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (check[i][j] == 0 && array[i][j] == 1) {
                    System.out.print(-1 + " ");
                    continue;
                }

                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void BFS(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        check[p.x][p.y] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < moveX.length; j++) {
                    int mX = tmp.x + moveX[j];
                    int mY = tmp.y + moveY[j];
                    if (mX >= 0 && mX < n && mY >= 0 && mY < m && array[mX][mY] == 1 && check[mX][mY] == 0) {
                        check[mX][mY] = check[tmp.x][tmp.y] + 1;
                        q.add(new Point(mX, mY));
                    }
                }
            }
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}