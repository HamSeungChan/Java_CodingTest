import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] array;
    static int[] MOVE_Y = {1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            recursion(0, i, -1, array[0][i]);
        }

        System.out.println(answer);
    }

    public static void recursion(int x, int y, int beforeMove, int sum) {

        // 달에 도착했을 때
        if (x == n - 1) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < MOVE_Y.length; i++) {

            if (beforeMove == i) {
                continue;
            }

            int moveX = x + 1;
            int moveY = y + MOVE_Y[i];

            if (checkRange(moveY)) {
                recursion(moveX, moveY, i, sum + array[moveX][moveY]);
            }
        }

    }

    public static boolean checkRange(int y) {
        return 0 <= y && y < m;
    }

}