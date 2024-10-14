import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  일의 시작을 최대한 늦히고 싶다.
 *
 * */


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][2];

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // 끝나는 시간이 가장 늦은거 부터
        Arrays.sort(array, (o1, o2) -> o2[1] - o1[1]);
        int lastTime = array[0][1];

        for (int i = 0; i < n; i++) {

            if (lastTime > array[i][1]) {
                lastTime = array[i][1];
            }

            if (lastTime - array[i][0] < 0) {
                lastTime = -1;
                break;
            }

            lastTime = lastTime - array[i][0];

        }
        System.out.println(lastTime);
    }
}