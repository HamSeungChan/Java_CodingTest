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
        int b = Integer.parseInt(token.nextToken());


        // 0 -> 선물의 가격
        // 1 -> 배송비
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {

            int[] sum = new int[n];
            for (int j = 0; j < n; j++) {
                sum[j] = array[j][0] / (i == j ? 2 : 1) + array[j][1];
            }

            Arrays.sort(sum);

            long totalValue = 0;
            int people = 0;
            for (int value : sum) {
                long newValue = totalValue + value;
                if (newValue > b) {
                    break;
                }
                people++;
                totalValue = newValue;
            }
            answer = Math.max(answer, people);
        }
        System.out.println(answer);
    }
}