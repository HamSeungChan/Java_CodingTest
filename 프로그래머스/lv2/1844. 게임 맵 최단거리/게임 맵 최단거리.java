import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] MOVE_X = {0, 1, 0, -1};
    int[] MOVE_Y = {1, 0, -1, 0};
    int[][] distance;

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        return move(maps, n, m);
    }

    public int move(int[][] maps, int n, int m) {
        int[][] distance = new int[n][m];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        maps[0][0] = 0;
        distance[0][0] = 1;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int mX = p.x + MOVE_X[i];
                int mY = p.y + MOVE_Y[i];
                if (mX >= 0 && mX < n && mY >= 0 && mY < m && maps[mX][mY] == 1) {
                    if (mX == n - 1 && mY == m - 1) return distance[p.x][p.y] + 1;
                    maps[mX][mY] = 0;
                    distance[mX][mY] = distance[p.x][p.y] + 1;
                    q.offer(new Point(mX, mY));
                }
            }
        }
        return -1;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}