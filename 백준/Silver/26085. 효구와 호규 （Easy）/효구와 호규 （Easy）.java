import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 0 또는 1 의 개수가 홀수면 모든 카드를 없앨 수 없다.
 * 2. 0 1 0 1
 *    1 0 1 0
 *    0 1 0 1   --> 이 모양만 아니면 계속 움직이면서 없앨 수 있다
 * */

public class Main {

    public static int[] MOVE_X = {1, 0, -1, 0};
    public static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int zeroCount = 0;
        int oneCount = 0;

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(token.nextToken());
                map[i][j] = tmp;
                if (tmp == 0) {
                    zeroCount++;
                    continue;
                }
                oneCount++;
            }
        }

        int answer = -1;
        if (zeroCount % 2 == 0 && oneCount % 2 == 0) {
            if (find(map, n, m)) {
                answer = 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean find(int[][] map, int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {

                    int moveX = i + MOVE_X[k];
                    int moveY = j + MOVE_Y[k];

                    if (0 <= moveX && moveX < n && 0 <= moveY && moveY < m && map[moveX][moveY] == map[i][j]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}