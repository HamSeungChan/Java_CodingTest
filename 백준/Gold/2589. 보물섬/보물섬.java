import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c, answer = 0;
    static char[][] map;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'L') {
                    bfs(new Point(i, j));
                }
            }
        }
        System.out.println(answer);
    }

    public static void bfs(Point startPoint) {

        boolean[][] check = new boolean[r][c];

        Queue<Point> q = new LinkedList<>();
        q.add(startPoint);
        check[startPoint.x][startPoint.y] = true;
        int depth = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int s = 0; s < size; s++) {
                Point now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int moveX = now.x + MOVE_X[i];
                    int moveY = now.y + MOVE_Y[i];

                    if (canMove(moveX, moveY, check)) {
                        check[moveX][moveY] = true;
                        q.offer(new Point(moveX, moveY));
                    }
                }
            }
            depth++;
        }
        answer = Math.max(answer, depth - 1);
    }

    public static boolean canMove(int x, int y, boolean[][] check) {
        return 0 <= x && x < r && 0 <= y && y < c && !check[x][y] && map[x][y] == 'L';
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