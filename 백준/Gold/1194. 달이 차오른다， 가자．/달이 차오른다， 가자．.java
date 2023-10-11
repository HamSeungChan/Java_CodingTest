import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][][] check;
    static int n, m;
    static char[] keys = {'a', 'b', 'c', 'd', 'e', 'f'};
    static char[] door = {'A', 'B', 'C', 'D', 'E', 'F'};
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        check = new boolean[n][m][64];
        map = new char[n][m];
        Point startPoint = null;
        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (c[j] == '0') {
                    startPoint = new Point(i, j, 0);
                }
                map[i][j] = c[j];
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }


        System.out.println(bfs(startPoint));
    }

    public static int bfs(Point startPoint) {
        int answer = -1;
        Queue<Point> q = new LinkedList<>();
        q.offer(startPoint);
        check[startPoint.x][startPoint.y][startPoint.key] = true;
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point tmp = q.poll();
                int key = tmp.key;
                for (int j = 0; j < MOVE_X.length; j++) {
                    int moveX = tmp.x + MOVE_X[j];
                    int moveY = tmp.y + MOVE_Y[j];
                    if (canMove(moveX, moveY, key)) {
                        if (map[moveX][moveY] == '.' || map[moveX][moveY] == '0') {
                            q.offer(new Point(moveX, moveY, key));
                            check[moveX][moveY][key] = true;
                        } else if (map[moveX][moveY] == '1') {
                            return depth + 1;
                        } else if (Character.isUpperCase(map[moveX][moveY])) {
                            int index = 0;
                            for (int k = 0; k < door.length; k++) {
                                if (door[k] == map[moveX][moveY]) {
                                    index = k;
                                    break;
                                }
                            }
                            if ((key & 1 << index) == 1 << index) {
                                q.offer(new Point(moveX, moveY, key));
                                check[moveX][moveY][key] = true;
                            }
                        } else if (Character.isLowerCase(map[moveX][moveY])) {
                            int index = 0;
                            for (int k = 0; k < keys.length; k++) {
                                if (keys[k] == map[moveX][moveY]) {
                                    index = k;
                                    break;
                                }
                            }
                            int newKey = key | 1 << index;
                            q.offer(new Point(moveX, moveY, newKey));
                            check[moveX][moveY][newKey] = true;
                        }
                    }
                }
            }
            depth++;
        }
        return answer;
    }

    public static boolean canMove(int x, int y, int key) {
        return x >= 0 && x < n && y >= 0 && y < m && !check[x][y][key] && map[x][y] != '#';
    }
}

class Point {
    int x;
    int y;
    int key;

    public Point(int x, int y, int key) {
        this.x = x;
        this.y = y;
        this.key = key;
    }
}