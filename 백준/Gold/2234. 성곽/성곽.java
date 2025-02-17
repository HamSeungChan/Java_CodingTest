import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] check;
    static int mergeMaxSize = 0;
    static int[] MOVE_X = {0, -1, 0, 1};
    static int[] MOVE_Y = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> hashMap = new HashMap<>();

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        map = new int[m][n];
        check = new int[m][n];


        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int count = 0;
        int value = 1;
        int maxSize = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == 0) {
                    int result = bfs(new Point(i, j), value);
                    maxSize = Math.max(maxSize, result);
                    hashMap.put(value, result);
                    count++;
                    value++;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int tmp = 1;
                for (int k = 0; k < MOVE_X.length; k++) {
                    if ((map[i][j] & tmp) == tmp) {

                        int moveX = i + MOVE_X[k];
                        int moveY = j + MOVE_Y[k];
                        if (0 <= moveX && moveX < m && 0 <= moveY && moveY < n && check[i][j] != check[moveX][moveY]) {
                            int sum = hashMap.get(check[i][j]) + hashMap.get(check[moveX][moveY]);
                            mergeMaxSize = Math.max(mergeMaxSize, sum);
                        }
                    }
                    tmp = tmp << 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n").append(maxSize).append("\n").append(mergeMaxSize);
        System.out.println(sb);
    }


    public static int bfs(Point start, int value) {

        int size = 1;
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);
        check[start.x][start.y] = value;

        while (!q.isEmpty()) {

            Point now = q.poll();
            int tmp = 1;
            for (int i = 0; i < MOVE_X.length; i++) {
                if ((map[now.x][now.y] & tmp) == 0) {
                    int moveX = now.x + MOVE_X[i];
                    int moveY = now.y + MOVE_Y[i];
                    if (inRange(moveX, moveY)) {
                        q.offer(new Point(moveX, moveY));
                        check[moveX][moveY] = value;
                        size++;
                    }
                }
                tmp = tmp << 1;
            }
        }
        return size;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n && check[x][y] == 0;
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