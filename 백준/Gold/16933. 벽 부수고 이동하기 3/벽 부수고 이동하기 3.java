import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static boolean[][][][] check;
    static int n, m, k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }


        int count = 1;
        check = new boolean[n][m][2][k + 1];

        Queue<Info> q = new ArrayDeque<>();
        q.add(new Info(0, 0, 0, 0));
        check[0][0][0][0] = true;
        boolean flag = false;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                Info now = q.poll();

                if (now.x == n - 1 && now.y == m - 1) {
                    flag = true;
                    break;
                }


                // 밤에 그래도 있는 경우
                if (now.time == 1) {
                    q.add(new Info(now.x, now.y, 0, now.breakCount));
                }


                // 움직이는 경우
                for (int j = 0; j < 4; j++) {
                    int x = now.x + MOVE_X[j];
                    int y = now.y + MOVE_Y[j];

                    if (!inRange(x, y)) {
                        continue;
                    }

                    // 밤에 벽을 만났을 때는 부술 수 없다.
                    if (map[x][y] == 1 && now.time == 1) {
                        continue;
                    }

                    int breakCount = now.breakCount + (map[x][y] == 1 ? 1 : 0);
                    int day = (now.time == 1 ? 0 : 1);

                    if (canMove(x, y, day, breakCount)) {
                        check[x][y][day][breakCount] = true;
                        q.add(new Info(x, y, day, breakCount));
                    }
                }
            }

            if (flag) {
                break;
            }

            count++;
        }

        System.out.println(flag ? count : -1);
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canMove(int x, int y, int time, int breakCount) {
        return breakCount <= k && !check[x][y][time][breakCount];
    }
}

class Info {
    int x;
    int y;
    int time;       // 0 -> 낮, 1 -> 밤
    int breakCount;

    public Info(int x, int y, int time, int breakCount) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.breakCount = breakCount;
    }
}
