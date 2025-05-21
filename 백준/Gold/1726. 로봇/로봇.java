import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] MOVE_X = {-1, 0, 1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static int[] turn = {-1, 1};
    static int[][] array;
    static int n, m;
    static boolean[][][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(token.nextToken()) - 1;
        int y = Integer.parseInt(token.nextToken()) - 1;
        int direction = Integer.parseInt(token.nextToken());
        Point start = new Point(x, y, newDirection(direction));

        token = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(token.nextToken()) - 1;
        y = Integer.parseInt(token.nextToken()) - 1;
        direction = Integer.parseInt(token.nextToken());
        Point end = new Point(x, y, newDirection(direction));


        check = new boolean[n][m][4];

        Queue<Point> q = new ArrayDeque<>();
        check[start.x][start.y][start.direction] = true;
        q.add(start);
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                Point now = q.poll();

//                System.out.println("now = " + now.x + " " + now.y + " " + now.direction);

                if (now.x == end.x && now.y == end.y && now.direction == end.direction) {
                    System.out.println(depth);
                    q.clear();
                    break;
                }

                // 명령 1. 현재 방향에서 1,2,3 칸 이동
                for (int j = 1; j <= 3; j++) {
                    int moveX = now.x + MOVE_X[now.direction] * j;
                    int moveY = now.y + MOVE_Y[now.direction] * j;

                    if (canMove(moveX, moveY, now.direction)) {
                        if (array[moveX][moveY] == 1) {
                            break;
                        }
                        check[moveX][moveY][now.direction] = true;
                        q.add(new Point(moveX, moveY, now.direction));
                    }
                }

                // 명령 2. 왼쪽 또는 오른쪽으로 90도 회전
                // 왼쪽 - 1, 오른쪽 + 1
                for (int j = 0; j < turn.length; j++) {
                    int newDirection = now.direction + turn[j];
                    if (newDirection == -1) {
                        newDirection = 3;
                    }

                    if (newDirection == 4) {
                        newDirection = 0;
                    }

                    if (!check[now.x][now.y][newDirection]) {
                        check[now.x][now.y][newDirection] = true;
                        q.add(new Point(now.x, now.y, newDirection));
                    }
                }
            }
            depth++;
        }
    }

    public static boolean canMove(int x, int y, int direction) {
        return 0 <= x && x < n && 0 <= y && y < m && !check[x][y][direction];
    }


    public static int newDirection(int direction) {

        if (direction == 2) {
            return 3;
        }

        if (direction == 3) {
            return 2;
        }

        if (direction == 4) {
            return 0;
        }

        return direction;
    }

}

class Point {
    int x;
    int y;
    int direction;

    public Point(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}

