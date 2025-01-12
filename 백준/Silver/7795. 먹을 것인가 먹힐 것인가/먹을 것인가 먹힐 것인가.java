import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {

            token = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());

            int[] arrayA = new int[n];
            int[] arrayB = new int[m];

            token = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arrayA[i] = Integer.parseInt(token.nextToken());
            }

            token = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                arrayB[i] = Integer.parseInt(token.nextToken());
            }

            Arrays.sort(arrayB);

            int count = 0;
            for (int i = 0; i < n; i++) {
                int now = arrayA[i];

                int lt = 0;
                int rt = m - 1;
                int leftIndex = -1;

                while (lt <= rt) {

                    int mid = (lt + rt) / 2;
                    if (arrayB[mid] < now) {
                        lt = mid + 1;
                        leftIndex = mid;
                        continue;
                    }
                    rt = mid - 1;
                }

                count += leftIndex + 1;
            }

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

}