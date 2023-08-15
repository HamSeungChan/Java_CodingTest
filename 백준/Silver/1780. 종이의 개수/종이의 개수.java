import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static int zeroCount = 0;
    public static int minusCount = 0;
    public static int oneCount = 0;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        checkNumber(n, 0, 0);

        StringBuilder sb = new StringBuilder();
        sb.append(minusCount).append("\n");
        sb.append(zeroCount).append("\n");
        sb.append(oneCount);

        System.out.print(sb);
    }

    public static void checkNumber(int size, int startX, int startY) {


        // 같은 수로 이뤄졌는지 확인하는 로직
        int tmp = array[startX][startY];    // 초기 tmp 값은 startX와 startY에 있는 값으로 설정
        boolean flag = true;    // 같은 값으로 이뤄졌으면 true
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (tmp != array[i][j]) {
                    flag = false;   // 다른 값이면 false
                    break;
                }
                tmp = array[i][j];  // 다음 값을 비교하기 위해서 tmp 값을 바꾸어 준다.
            }
        }

        if (flag) {     // 같은 값이라면 위에서 사용한 tmp 값을 통해 0 -1 1 인지 구분한다
            if (tmp == 0) {
                zeroCount++;
            } else if (tmp == 1) {

                oneCount++;
            } else if (tmp == -1) {
                minusCount++;
            }
        } else {
            int newSize = size / 3;    // 배열을 나누어 준다.


            for (int i = startX; i < startX + size; i += newSize) { //분할 정복!
                for (int j = startY; j < startY + size; j += newSize) {
                    checkNumber(newSize, i, j);
                }
            }
        }
    }
}