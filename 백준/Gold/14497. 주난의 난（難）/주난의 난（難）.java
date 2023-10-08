import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static Point start;
    static Point goal;
    static int n, m;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        map = new int[n + 1][m + 1];
        token = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        goal = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));

        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                if (s[j - 1].equals("#")) {
                    map[i][j] = 2;
                } else if (s[j - 1].equals("*")) {
                    map[i][j] = 3;
                } else {
                    map[i][j] = Integer.parseInt(s[j - 1]);
                }
            }
        }

        int count = 0;
        while (true) {
            count++;
            if (bfs() == 1) {
                break;
            }
        }
        System.out.println(count);
    }

    public static int bfs() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] check = new boolean[n + 1][m + 1];
        q.offer(start);
        check[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < MOVE_X.length; i++) {
                int moveX = tmp.x + MOVE_X[i];
                int moveY = tmp.y + MOVE_Y[i];
                if (canMove(moveX, moveY, check)) {
                    check[moveX][moveY] = true;
                    if (map[moveX][moveY] == 2) {
                        return 1;
                    } else if (map[moveX][moveY] == 1) {
                        map[moveX][moveY] = 0;
                    } else {
                        q.offer(new Point(moveX, moveY));
                    }
                }
            }
        }
        return 0;
    }

    public static boolean canMove(int x, int y, boolean[][] check) {
        return x >= 1 && x <= n && y >= 1 && y <= m && !check[x][y];
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