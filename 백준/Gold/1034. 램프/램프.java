import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int max = 0;

        String[] array = new String[n];
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            array[i] = br.readLine();
        }


        int k = Integer.parseInt(br.readLine());
        int oddEven = k % 2;
        if (k > 50) {
            k = 50;
        }
        for (int i = 0; i < n; i++) {

            if (check[i]) {
                continue;
            }

            int zeroCount = 0;
            for (int j = 0; j < m; j++) {
                if (array[i].charAt(j) == '0') {
                    zeroCount++;
                }
            }


            if (zeroCount % 2 != oddEven || zeroCount > k) {
                continue;
            }


            int count = 0;
            for (int j = 0; j < n; j++) {
                if (array[i].equals(array[j])) {
                    count++;
                    check[j] = true;
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);


    }
}