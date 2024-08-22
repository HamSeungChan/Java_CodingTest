import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int h = Integer.parseInt(token.nextToken());

        int[] imosArray = new int[h + 1];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                imosArray[1]++;
                imosArray[tmp + 1]--;
            } else {
                imosArray[h - tmp + 1]++;
            }
        }

        int minValue = Integer.MAX_VALUE;
        int minCount = 0;
        for (int i = 1; i <= h; i++) {
            imosArray[i] = imosArray[i - 1] + imosArray[i];
            if (imosArray[i] < minValue) {
                minValue = imosArray[i];
                minCount = 1;
                continue;
            }

            if (imosArray[i] == minValue) {
                minCount++;
            }
        }
        System.out.println(minValue + " " + minCount);
    }
}