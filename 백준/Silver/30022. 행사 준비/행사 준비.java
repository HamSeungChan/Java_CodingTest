import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        long[][] array = new long[n][2];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                array[i][j] = Long.parseLong(token.nextToken());
            }
        }

        Arrays.sort(array, (o1, o2) -> (int) (Math.abs(o2[0] - o2[1]) - Math.abs(o1[0] - o1[1])));

        int aCount = 0;
        int bCount = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {

            // a < b
            if (array[i][0] < array[i][1]) {

                // a의 pickCount 확인
                if (aCount < a) {
                    answer += array[i][0];
                    aCount++;
                } else {
                    answer += array[i][1];
                    bCount++;
                }
            } else {
                if (bCount < b) {
                    answer += array[i][1];
                    bCount++;
                } else {
                    answer += array[i][0];
                    aCount++;
                }
            }
        }

        System.out.println(answer);
    }
}