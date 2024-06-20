import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            token = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(token.nextToken());
            int n = Integer.parseInt(token.nextToken());

            int[][] array = new int[4][n];

            for (int i = 0; i < 4; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    array[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int[] sumA = new int[n * n];
            int[] sumB = new int[n * n];

            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sumA[index++] = array[0][i] + array[1][j];
                }
            }

            index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sumB[index++] = array[2][i] + array[3][j];
                }
            }

            Arrays.sort(sumA);
            Arrays.sort(sumB);

            int lt = 0;
            int rt = sumB.length - 1;
            int answer = Integer.MAX_VALUE;

            while (true) {
                int sum = sumA[lt] + sumB[rt];
                answer = find(answer, sum);

                if (sum == k) {
                    break;
                } else if (sum < k) {
                    lt++;
                } else {
                    rt--;
                }
                if (lt == n * n || rt == -1) {
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static int find(int answer, int newValue) {

        if (Math.abs(k - answer) == Math.abs(k - newValue)) {
            return Math.min(answer, newValue);
        }
        return Math.abs(k - answer) < Math.abs(k - newValue) ? answer : newValue;
    }

}