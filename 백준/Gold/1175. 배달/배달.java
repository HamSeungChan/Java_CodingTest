import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static int n, m;
    static int[][] map;
    static boolean[][][][][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        map = new int[n][m];
        check = new boolean[n][m][5][2][2];
        Point start = null;
        int friend = 1;
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (tmp[j].equals("S")) {
                    start = new Point(i, j, -1, 0, 0);
                } else if (tmp[j].equals("C")) {
                    map[i][j] = map[i][j] + friend++;
                } else if (tmp[j].equals("#")) {
                    map[i][j] = -1;
                }
            }
        }

        Queue<Point> q = new ArrayDeque<>();
        int answer = -1;
        q.add(start);
        check[start.x][start.y][4][0][0] = true;
        int depth = 0;
        boolean flag = false;
        while (!q.isEmpty()) {

            if (flag) {
                break;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point now = q.poll();

                if (flag) {
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    if (now.before == j) {
                        continue;
                    }
                    int moveX = now.x + MOVE_X[j];
                    int moveY = now.y + MOVE_Y[j];


                    if (canMove(moveX, moveY, j, now.check1, now.check2)) {

                        Point newPoint = new Point(moveX, moveY, j, now.check1, now.check2);

                        if (map[moveX][moveY] == 1) {
                            newPoint.check1 = 1;
                        } else if (map[moveX][moveY] == 2) {
                            newPoint.check2 = 1;
                        } else if (map[moveX][moveY] == 3) {
                            newPoint.check1 = 1;
                            newPoint.check2 = 1;
                        }

                        if (newPoint.check1 == 1 && newPoint.check2 == 1) {
                            answer = depth + 1;
                            flag = true;
                            break;
                        }

                        check[moveX][moveY][j][newPoint.check1][newPoint.check2] = true;
                        q.add(newPoint);
                    }
                }
            }

            depth++;
        }

        System.out.println(answer);
    }

    public static boolean canMove(int x, int y, int beforeDirection, int check1, int check2) {
        return 0 <= x && x < n && 0 <= y && y < m && map[x][y] != -1 && !check[x][y][beforeDirection][check1][check2];
    }
}

class Point {
    int x;
    int y;
    int before;
    int check1;
    int check2;


    public Point(int x, int y, int before, int check1, int check2) {
        this.x = x;
        this.y = y;
        this.before = before;
        this.check1 = check1;
        this.check2 = check2;
    }
}