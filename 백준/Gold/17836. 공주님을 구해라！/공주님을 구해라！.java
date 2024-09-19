import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][][] check;
    static int[][] map;
    static int n, m;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        int t = Integer.parseInt(token.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        check = new boolean[n][m][2];
        int answer = move();
        System.out.println(answer > t ? "Fail" : answer);
    }


    public static int move() {
        Queue<Point> q = new ArrayDeque<>();
        int count = 0;
        q.add(new Point(0, 0, 0));
        check[0][0][0] = true;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int s = 0; s < size; s++) {

                Point now = q.poll();

                if (now.x == n - 1 && now.y == m - 1) {
                    return count;
                }

                for (int i = 0; i < 4; i++) {
                    int moveX = now.x + MOVE_X[i];
                    int moveY = now.y + MOVE_Y[i];

                    if (now.item == 1) {
                        if (canMove(moveX, moveY, now.item)) {
                            check[moveX][moveY][now.item] = true;
                            q.add(new Point(moveX, moveY, now.item));
                        }
                        continue;
                    }

                    if (canMove(moveX, moveY, now.item) && isWall(moveX, moveY)) {
                        check[moveX][moveY][now.item] = true;
                        if (map[moveX][moveY] == 2) {
                            check[moveX][moveY][1] = true;
                            q.add(new Point(moveX, moveY, 1));
                            q.add(new Point(moveX, moveY, 1));
                            continue;
                        }
                        q.add(new Point(moveX, moveY, now.item));
                    }
                }
            }
            count++;
        }
        return 100000000;
    }

    public static boolean canMove(int x, int y, int z) {
        return 0 <= x && x < n && 0 <= y && y < m && !check[x][y][z];
    }

    public static boolean isWall(int x, int y) {
        return map[x][y] != 1;
    }
}

class Point {

    int x;
    int y;
    int item;

    public Point(int x, int y, int item) {
        this.x = x;
        this.y = y;
        this.item = item;
    }
}