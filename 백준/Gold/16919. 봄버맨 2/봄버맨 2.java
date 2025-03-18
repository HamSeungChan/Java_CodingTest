import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static int r, c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());

        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = tmp[j].equals(".") ? -1 : 1;
            }
        }

        // false -> 폭탄 설치할 타임
        // true -> 폭탄 터지는 타이밍
        boolean flag = true;

        if (n >= 3) {
            for (int k = 1; k < 2; k++) {
                timeFLow(map);
            }
        }

        int range = (n - 2) % 4 == 0 ? 4 : (n - 2) % 4;
        for (int k = 0; k < range; k++) {
            timeFLow(map);
            if (flag) {
                bomb(map);
            }
            flag = !flag;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j] == -1 ? "." : "O");
            }
            System.out.println();
        }
    }

    // 1초가 흐른다 && 폭탄을 설치
    public static void timeFLow(int[][] map) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] += 1;
            }
        }
    }

    // 폭탄을 터트린다.
    public static void bomb(int[][] map) {

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (map[i][j] == 3) {

                    map[i][j] = -1;
                    for (int k = 0; k < 4; k++) {

                        int moveX = i + MOVE_X[k];
                        int moveY = j + MOVE_Y[k];

                        if (0 <= moveX && moveX < r && 0 <= moveY && moveY < c) {
                            if (map[moveX][moveY] == 3) {
                                continue;
                            }
                            map[moveX][moveY] = -1;
                        }
                    }
                }
            }
        }
    }
}
