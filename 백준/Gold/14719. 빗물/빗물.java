import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());

        int[] array = new int[w];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < w; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int answer = 0;
        for (int i = 1; i <= h; i++) {
            int startPoint = -1;
            int endPoint = -1;

            for (int j = 0; j < w; j++) {
                if (array[j] >= i) {
                    if (startPoint == -1) {
                        startPoint = j;
                    }
                    endPoint = j;
                }
            }
            
            if (startPoint == -1) {
                continue;
            }
            
            for (int j = startPoint; j <= endPoint; j++) {
                if (array[j] < i) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}