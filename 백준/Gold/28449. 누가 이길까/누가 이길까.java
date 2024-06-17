import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(b);

        long winCount = 0;
        long loseCount = 0;
        long drawCount = 0;

        for (int i = 0; i < n; i++) {

            int tmp = a[i];
            int lt = 0;
            int rt = b.length - 1;
            int value1 = -1;

            // 같거나 작은 것 중에 가장 오른쪽
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (b[mid] <= tmp) {
                    lt = mid + 1;
                    value1 = mid;
                } else {
                    rt = mid - 1;
                }
            }

            // 같거나 큰 것 중에 가장 왼쪽
            lt = 0;
            rt = b.length - 1;
            int value2 = b.length;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (b[mid] >= tmp) {
                    rt = mid - 1;
                    value2 = mid;
                } else {
                    lt = mid + 1;
                }
            }


            long draw = value1 - value2 + 1;
            winCount += (value1 - draw + 1);
            loseCount += (b.length - value2 - draw);
            drawCount += draw;

        }
        System.out.println(winCount + " " + loseCount + " " + drawCount);
    }
}