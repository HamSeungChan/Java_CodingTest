import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, answer;
    static int[][] array;

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

        combination(0, 0, new boolean[m]);
        System.out.println(answer);

    }

    public static void combination(int index, int pickCount, boolean[] pick) {

        if (pickCount == 3) {

            int[] bestScore = new int[n];
            for (int i = 0; i < pick.length; i++) {

                // 선택된 치킨
                if (pick[i]) {
                    for (int j = 0; j < n; j++) {
                        bestScore[j] = Math.max(bestScore[j], array[j][i]);
                    }
                }
            }


            int total = 0;
            for (int i : bestScore) {
                total += i;
            }

            answer = Math.max(answer, total);
            return;
        }

        for (int i = index; i < m; i++) {
            pick[i] = true;
            combination(i + 1, pickCount + 1, pick);
            pick[i] = false;
        }
    }
}