import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int answer;
    static int[][] result = new int[6][3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        for (int i = 0; i < 4; i++) {

            token = new StringTokenizer(br.readLine(), " ");
            int[][] goal = new int[6][3];
            int totalCount = 0;
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    goal[j][k] = Integer.parseInt(token.nextToken());
                    totalCount += goal[j][k];
                }
            }

            answer = 0;
            if (totalCount != 30) {
                sb.append(answer).append(" ");
                continue;
            }
            fight(0, 1, goal);
            sb.append(answer).append(" ");
        }

        System.out.print(sb);
    }

    public static void fight(int a, int b, int[][] goal) {

        if (b == 6) {
            a++;
            b = a + 1;
        }

        if (a == 5) {
            answer = 1;
            return;
        }

        // 이기는 경우
        result[a][0]++;
        result[b][2]++;

        if (result[a][0] <= goal[a][0] && result[b][2] <= goal[b][2]) {
            fight(a, b + 1, goal);
        }
        result[a][0]--;
        result[b][2]--;

        // 비기는 경우
        result[a][1]++;
        result[b][1]++;
        if (result[a][1] <= goal[a][1] && result[b][1] <= goal[b][1]) {
            fight(a, b + 1, goal);
        }
        result[a][1]--;
        result[b][1]--;

        // 지는 경우
        result[a][2]++;
        result[b][0]++;
        if (result[a][2] <= goal[a][2] && result[b][0] <= goal[b][0]) {
            fight(a, b + 1, goal);
        }
        result[a][2]--;
        result[b][0]--;
    }
}