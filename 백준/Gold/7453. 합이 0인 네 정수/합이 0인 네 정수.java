import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] array = new int[4][n];

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                array[j][i] = Integer.parseInt(token.nextToken());
            }
        }

        int[] sumA = new int[n * n];
        int[] sumB = new int[n * n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumA[index] = array[0][i] + array[1][j];
                sumB[index] = array[2][i] + array[3][j];
                index++;
            }
        }

        Arrays.sort(sumA);
        Arrays.sort(sumB);

        int lt = 0;
        int rt = n * n - 1;
        long answer = 0;

        while (true) {
            int value = sumA[lt] + sumB[rt];
            if (value == 0) {

                long leftSameCount = 1;
                long rightSameCount = 1;

                while (lt != n * n - 1 && sumA[lt] == sumA[lt + 1]) {
                    leftSameCount++;
                    lt++;
                }

                while (rt != 0 && sumB[rt] == sumB[rt - 1]) {
                    rightSameCount++;
                    rt--;
                }

                lt++;
                rt--;
                answer += leftSameCount * rightSameCount;

            } else if (value < 0) {
                lt++;
            } else {
                rt--;
            }

            if (lt == n * n || rt == -1) {
                break;
            }
        }
        System.out.println(answer);
    }
}