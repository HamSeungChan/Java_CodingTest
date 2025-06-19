import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] MOVE_X = {1, 0, -1, 0};
    public static int[] MOVE_Y = {0, -1, 0, 1};
    static int w, h;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(token.nextToken());
            h = Integer.parseInt(token.nextToken());

            Queue<Point> q = new ArrayDeque<>();
            int[][] check = new int[h][w];
            int[][] moveCheck = new int[h][w];
            char[][] array = new char[h][w];
            Point start = null;

            for (int j = 0; j < h; j++) {
                char[] tmp = br.readLine().toCharArray();
                for (int k = 0; k < w; k++) {
                    array[j][k] = tmp[k];
                    if (tmp[k] == '*') {
                        check[j][k] = 1;
                        q.add(new Point(j, k));
                    } else if (tmp[k] == '@') {
                        moveCheck[j][k] = 1;
                        start = new Point(j, k);
                    }
                }
            }

            while (!q.isEmpty()) {
                Point now = q.poll();

                for (int j = 0; j < MOVE_X.length; j++) {
                    int moveX = now.x + MOVE_X[j];
                    int moveY = now.y + MOVE_Y[j];

                    // 범위를 벗어난 경우
                    if (!inRange(moveX, moveY)) {
                        continue;
                    }

                    // 벽인 경우
                    if (array[moveX][moveY] == '#') {
                        continue;
                    }

                    // 이미 불이 붙은 경우
                    if (check[moveX][moveY] != 0) {
                        continue;
                    }


                    check[moveX][moveY] = check[now.x][now.y] + 1;
                    q.add(new Point(moveX, moveY));
                }
            }

//            for (int j = 0; j < h; j++) {
//                for (int k = 0; k < w; k++) {
//                    System.out.print(check[j][k]);
//                }
//                System.out.println();
//            }

            Queue<Point> hq = new ArrayDeque<>();
            hq.add(start);
            boolean flag = false;
            while (!hq.isEmpty()) {
                int depth = hq.size();
                for (int d = 0; d < depth; d++) {

                    Point now = hq.poll();

                    for (int j = 0; j < MOVE_X.length; j++) {
                        int moveX = now.x + MOVE_X[j];
                        int moveY = now.y + MOVE_Y[j];

                        // 탈출 성공한 경우
                        if (moveX < 0 || moveX >= h || moveY < 0 || moveY >= w) {
                            flag = true;
                            sb.append(moveCheck[now.x][now.y]).append("\n");
                            break;
                        }

                        // 이미 방문한 곳을 지나가는 경우
                        if (moveCheck[moveX][moveY] != 0) {
                            continue;
                        }

                        // 이미 불이 붙은 곳을 지나가는 경우
                        if (check[moveX][moveY] == 0) {

                        } else if (check[moveX][moveY] <= moveCheck[now.x][now.y] + 1) {
                            continue;
                        }

                        // 벽
                        if (array[moveX][moveY] == '#') {
                            continue;
                        }

                        hq.add(new Point(moveX, moveY));
                        moveCheck[moveX][moveY] = moveCheck[now.x][now.y] + 1;
                    }

                    if (flag) {
                        hq.clear();
                        break;
                    }
                }
            }

            if (!flag) {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < h && 0 <= y && y < w;
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