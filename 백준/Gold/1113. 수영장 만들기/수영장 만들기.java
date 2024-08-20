import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] mapResult;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        map = new int[n][m];
        mapResult = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] array = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(array[j]);
            }
        }

        int answer = 0;
        for (int height = 2; height <= 9; height++) {
            boolean[][] result = mapScan(height);
            boolean[][] check = new boolean[n][m];  // check 여부를 기록하는 boolean 배열


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (result[i][j] && !check[i][j]) {
                        getSize(i, j, result, check, height);
                    }
                }
            }

            answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer += (Math.max(mapResult[i][j] - map[i][j], 0));
                }
            }
        }

        System.out.println(answer);
    }

    // true의 size를 구한다.
    // 모서리 부분이 true이면 그 구역은 땅으로 물이 흘러 내려간다
    public static void getSize(int x, int y, boolean[][] result, boolean[][] check, int height) {

        int size = 0;
        boolean flag = false;
        Queue<Point> q = new LinkedList<>();
        List<Point> list = new ArrayList<>();
        check[x][y] = true;
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point now = q.poll();
            list.add(now);
            size += height - map[now.x][now.y];

            // 물이 바닥으로 떨어진다
            if (now.x == 0 || now.x == n - 1 || now.y == 0 || now.y == m - 1) {
                flag = true;
            }

            for (int i = 0; i < 4; i++) {
                int moveX = now.x + MOVE_X[i];
                int moveY = now.y + MOVE_Y[i];

                if (0 <= moveX && moveX < n && 0 <= moveY && moveY < m && result[moveX][moveY] && !check[moveX][moveY]) {
                    check[moveX][moveY] = true;
                    q.offer(new Point(moveX, moveY));
                }
            }
        }

        if (flag) {
            return;
        }

        for (Point point : list) {
            mapResult[point.x][point.y] = Math.max(mapResult[point.x][point.y], height);
        }
    }


    // 높이를 기준으로 map을 스캔하는 메소드
    public static boolean[][] mapScan(int height) {
        boolean[][] result = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] < height) {
                    result[i][j] = true;
                }
            }
        }
        return result;
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