import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static int r, c;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        int size = (int) Math.pow(2, n);
        divide(0, 0, size);
        System.out.println(answer);
    }

    public static void divide(int startX, int startY, int size) {

        if (size == 1) {

            return;

        } else {

            if (r < startX + size / 2 && c < startY + size / 2) {
                divide(startX, startY, size / 2);
            } else if (r < startX + size / 2 && c < c + size) {
                answer += size / 2 * size / 2;
                divide(startX, startY + size / 2, size / 2);

            } else if (r < r + size && c < startY + size / 2) {
                answer += (size / 2 * size / 2) * 2;
                divide(startX + size / 2, startY, size / 2);
            } else if (r < r + size && c < c + size) {
                answer += (size / 2 * size / 2) * 3;
                divide(startX + size / 2, startY + size / 2, size / 2);
            }

        }

    }

}