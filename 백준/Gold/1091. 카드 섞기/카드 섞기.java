import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] position = new int[n];
        int[] moveInfo = new int[n];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            position[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            moveInfo[i] = Integer.parseInt(token.nextToken());
        }

        // 충분히 큰 수로 설정
        int totalMoveLimit = 1000000;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < totalMoveLimit; i++) {
            if (isCorrectLocation(position)) {
                flag = true;
                break;
            }

            int[] newPosition = new int[n];
            for (int j = 0; j < n; j++) {
                newPosition[moveInfo[j]] = position[j];
            }
            position = newPosition;
            count++;
        }
        System.out.println(flag ? count : -1);
    }

    public static boolean isCorrectLocation(int[] position) {

        for (int i = 0; i < n; i++) {
            if (i % 3 != position[i]) {
                return false;
            }
        }
        return true;
    }
}
