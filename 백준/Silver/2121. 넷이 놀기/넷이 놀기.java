import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        array = new int[n][2];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            array[i][0] = Integer.parseInt(token.nextToken());
            array[i][1] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int answer = 0;
        for (int i = 0; i < n; i++) {

            int x = array[i][0];
            int y = array[i][1];

            if (find(x + a, y) && find(x, y + b) && find(x + a, y + b)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean find(int x, int y) {

        int lt = 0;
        int rt = n - 1;
        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            int nowX = array[mid][0];
            int nowY = array[mid][1];

            if (nowX < x || (nowX == x && nowY < y)) {
                lt = mid + 1;
            } else if (nowX > x || nowY > y) {
                rt = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}