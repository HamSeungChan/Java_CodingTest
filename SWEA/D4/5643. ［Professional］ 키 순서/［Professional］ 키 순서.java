import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, m, highPeopleCount, lowPeopleCount;
    static boolean[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            array = new boolean[n + 1][n + 1];

            // 키 순서 입력
            for (int i = 0; i < m; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                array[a][b] = true;
            }

            int answer = 0;
            for (int i = 1; i <= n; i++) {
                highPeopleCount = lowPeopleCount = 0;
                checkHigh(i, new boolean[n + 1]);
                checkLow(i, new boolean[n + 1]);
                if (lowPeopleCount + highPeopleCount == n - 1) {
                    answer++;
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);

    }

    private static void checkLow(int cur, boolean[] check) {
        check[cur] = true;
        for (int i = 1; i <= n; i++) {
            if (array[i][cur] && !check[i]) {
                lowPeopleCount++;
                checkLow(i, check);
            }
        }
    }

    public static void checkHigh(int cur, boolean[] check) {
        check[cur] = true;
        for (int i = 1; i <= n; i++) {
            if (array[cur][i] && !check[i]) {
                highPeopleCount++;
                checkHigh(i, check);
            }
        }
    }
}