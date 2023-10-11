import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h, k;

    public static int[] MOVE_X = {1, 0, -1, 0};
    public static int[] MOVE_Y = {0, 1, 0, -1};
    public static int[] JUMP_X = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int[] JUMP_Y = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static int[][] map;
    public static boolean[][][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        w = Integer.parseInt(token.nextToken());
        h = Integer.parseInt(token.nextToken());

        map = new int[h][w];
        int[][][] route = new int[h][w][k + 1];
        check = new boolean[h][w][k + 1];
        for (int i = 0; i < h; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        System.out.println(bfs(map, route));

    }

    public static int bfs(int[][] map, int[][][] route) {

        int answer = -1;
        int depth = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Point tmp = q.poll();
                if (tmp.x == h - 1 && tmp.y == w - 1) {
                    return depth;
                }
                int jumpCount = tmp.jumpCount;
                for (int i = 0; i < MOVE_X.length; i++) {
                    int moveX = tmp.x + MOVE_X[i];
                    int moveY = tmp.y + MOVE_Y[i];
                    if (canMove(moveX, moveY, jumpCount)) {
                        q.offer(new Point(moveX, moveY, jumpCount));
                        check[moveX][moveY][jumpCount] = true;
                    }
                }
                if (jumpCount < k) {
                    for (int i = 0; i < JUMP_X.length; i++) {
                        int moveX = tmp.x + JUMP_X[i];
                        int moveY = tmp.y + JUMP_Y[i];
                        if (canMove(moveX, moveY, jumpCount + 1)) {
                            q.offer(new Point(moveX, moveY, jumpCount + 1));
                            check[moveX][moveY][jumpCount + 1] = true;
                        }
                    }
                }
            }
            depth++;
        }
        return answer;
    }

    public static boolean canMove(int x, int y, int jumpCount) {
        return x >= 0 && x < h && y >= 0 && y < w && map[x][y] == 0 && !check[x][y][jumpCount];
    }

}

class Point {
    int x;
    int y;
    int jumpCount;

    public Point(int x, int y, int jumpCount) {
        this.x = x;
        this.y = y;
        this.jumpCount = jumpCount;
    }
}