import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[1001];

        int maxHigh = 0;
        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(token.nextToken());
            int h = Integer.parseInt(token.nextToken());
            maxHigh = Math.max(maxHigh, h);
            array[l] = h;
        }

        int answer = 0;
        for (int i = 1; i <= maxHigh; i++) {

            int startPoint = 0;
            int endPoint = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] >= i) {
                    if (startPoint == 0) {
                        startPoint = j;
                    }
                    endPoint = j;
                }
            }
            answer += (endPoint - startPoint + 1);
        }
        System.out.println(answer);
    }
}