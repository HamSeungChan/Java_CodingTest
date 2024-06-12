import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, d, answer = Integer.MAX_VALUE;
    static int[][] road;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        d = Integer.parseInt(token.nextToken());

        road = new int[n][3];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                road[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        Arrays.sort(road, (o1, o2) -> o1[0] - o2[0]);
        recursion(0, 0, 0);
        System.out.println(answer);
    }

    public static void recursion(int depth, int position, int move) {

        if (depth == n) {
            if (position > d) {
                return;
            }
            answer = Math.min(answer, move + d - position);
            return;
        }

        // 사용하지 않는 경우
        recursion(depth + 1, position, move);

        // 사용한 경우
        // 우선 position에서 사용 할 수 있는지 확인
        if (position <= road[depth][0]) {
            recursion(depth + 1, road[depth][1], move + road[depth][0] - position + road[depth][2]);
        }
    }
}