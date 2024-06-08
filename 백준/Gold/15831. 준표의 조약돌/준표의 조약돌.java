import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());

        char[] array = br.readLine().toCharArray();
        int lt = -1;
        int answer = 0;

        int blackCount = 0;
        int whiteCount = 0;

        for (int rt = 0; rt < n; rt++) {

            if (array[rt] == 'W') {
                whiteCount++;
            } else {
                blackCount++;
            }

            while (blackCount > b) {
                lt++;
                if (array[lt] == 'W') {
                    whiteCount--;
                } else {
                    blackCount--;
                }
            }
            if (whiteCount >= w) {
                answer = Math.max(answer, rt - lt);
            }
        }
        System.out.println(answer);
    }

}