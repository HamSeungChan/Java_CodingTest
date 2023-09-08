import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int r1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());
            int r2 = Integer.parseInt(token.nextToken());

            sb.append(check(x1, y1, r1, x2, y2, r2)).append("\n");

        }

        System.out.print(sb);

    }

    public static int check(int x1, int y1, int r1, int x2, int y2, int r2) {

        int distance = (int) ( Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        } else if (distance > Math.pow(r1 + r2, 2)) {
            return 0;
        } else if (distance < Math.pow(r1 - r2, 2)) {
            return 0;
        } else if (distance == Math.pow(r1 + r2, 2)) {
            return 1;
        } else if (distance == Math.pow(r1- r2, 2)) {
            return 1;
        } else {
            return 2;
        }
    }
}