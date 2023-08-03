import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] food;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        food = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            food[i][0] = Integer.parseInt(s[0]);
            food[i][1] = Integer.parseInt(s[1]);
        }

        subset(0,1,0,0);
        System.out.println(answer);
    }

    public static void subset(int index, int sourSum, int bitterSum, int useCount) {
        if (index == n) {
            if (useCount > 0) {
                answer = Math.min(answer, Math.abs(sourSum - bitterSum));
            }
        } else {
            subset(index + 1, sourSum * food[index][0], bitterSum + food[index][1]
                    , useCount + 1);
            subset(index + 1, sourSum, bitterSum, useCount);
        }
    }

}