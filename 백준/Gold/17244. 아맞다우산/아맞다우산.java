import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, number, total;
    static char[][] map;
    static boolean[][][] check;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());

        map = new char[n][m];

        number = 0;
        Point start = null;

        for (int i = 0; i < n; i++) {

            String tmp = br.readLine();
            for (int j = 0; j < tmp.length(); j++) {
                char c = tmp.charAt(j);

                if (c == 'S') {
                    start = new Point(i, j, 0);
                    map[i][j] = c;
                    continue;
                }

                if (c == 'X') {
                    map[i][j] = (char) (number + '0');
                    number++;
                    continue;
                }

                map[i][j] = c;
            }
        }

        for (int i = 0; i < number; i++) {
            total = total | (1 << i);
        }
        check = new boolean[n][m][1 << (number + 1)];
        System.out.println(bfs(start));
    }

    public static int bfs(Point start) {


        check[start.x][start.y][start.count] = true;
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);
        int moveCount = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point now = q.poll();
                for (int j = 0; j < MOVE_X.length; j++) {
                    int moveX = now.x + MOVE_X[j];
                    int moveY = now.y + MOVE_Y[j];

                    // 범위 안에 있고 벽이 아니다.
                    if (canMove(moveX, moveY)) {
                        Point newPoint = null;
                        // 출구를 만난 경우
                        if (map[moveX][moveY] == 'E') {
                            if ((now.count & total) == total) {
                                return moveCount + 1;
                            }
                            continue;
                        }

                        // 물건을 마주친 경우 X
                        else if (map[moveX][moveY] == '.' || map[moveX][moveY] == 'S') {
                            newPoint = new Point(moveX, moveY, now.count);
                        }

                        // 물건을 마주친 경우 0
                        else {
                            int newCount = now.count | 1 << (map[moveX][moveY] - '0');
                            newPoint = new Point(moveX, moveY, newCount);
                        }

                        if (!check[newPoint.x][newPoint.y][newPoint.count]) {
                            check[newPoint.x][newPoint.y][newPoint.count] = true;
                            q.add(newPoint);
                        }
                    }
                }
            }
            moveCount++;
        }
        return moveCount;
    }

    public static boolean canMove(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && map[x][y] != '#';
    }

}

class Point {
    int x;
    int y;
    int count;

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
