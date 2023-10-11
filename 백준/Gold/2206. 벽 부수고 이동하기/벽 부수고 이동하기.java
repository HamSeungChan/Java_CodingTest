import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][][] check;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        check = new boolean[n][m][2];
        System.out.println(bfs());
    }

    public static int bfs() {
        int answer = -1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));
        check[0][0][0] = true;
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Point tmp = q.poll();
                if (tmp.x == n - 1 && tmp.y == m - 1) {
                    return depth;
                }
                int breakCount = tmp.breakCount;
                for (int i = 0; i < MOVE_X.length; i++) {
                    int moveX = tmp.x + MOVE_X[i];
                    int moveY = tmp.y + MOVE_Y[i];
                    if (canMove(moveX, moveY, breakCount)) {
                        if (map[moveX][moveY] == 0) {
                            q.offer(new Point(moveX, moveY, breakCount));
                            check[moveX][moveY][breakCount] = true;
                        }
                        if (map[moveX][moveY] == 1 && breakCount == 0) {
                            q.offer(new Point(moveX, moveY, breakCount + 1));
                            check[moveX][moveY][breakCount + 1] = true;
                        }

                    }
                }
            }
            depth++;
        }
        return answer;
    }

    public static boolean canMove(int x, int y, int breakCount) {
        return x >= 0 && x < n && y >= 0 && y < m && !check[x][y][breakCount];
    }

}

class Point {
    int x;
    int y;
    int breakCount;

    public Point(int x, int y, int breakCount) {
        this.x = x;
        this.y = y;
        this.breakCount = breakCount;
    }
}