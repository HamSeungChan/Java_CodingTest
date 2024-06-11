import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        long k = Long.parseLong(token.nextToken());

        long tmp = 0;
        if (k % 2 == 0) {
            tmp = k / 2;
        } else {
            tmp = k / 2 + 1;
        }

        token = new StringTokenizer(br.readLine(), " ");
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(token.nextToken());
        }
        Arrays.sort(array);
        int lt = 0;
        int rt = n - 1;
        int useCount = 0;
        int answer = 0;

        while (lt <= rt) {

            if (array[rt] >= k) {
                useCount++;
                answer++;
                rt--;
                continue;
            }

            long sum = array[lt] + array[rt];
            if (lt < rt && sum >= tmp) {
                useCount += 2;
                answer++;
                lt++;
                rt--;
            } else {
                lt++;
            }
        }
        System.out.println(answer + (n - useCount) / 3);
    }
}