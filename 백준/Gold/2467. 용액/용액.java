import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(array);

        int lt = 0;
        int rt = n - 1;
        int answer = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();

        while (lt < rt) {
            int tmp = array[lt] + array[rt];
            if (Math.abs(tmp) < answer) {
                sb = new StringBuilder(array[lt] + " " + array[rt]);
                answer = Math.abs(tmp);
            }

            if (Math.abs(array[lt]) < Math.abs(array[rt])) {
                rt--;
            } else {
                lt++;
            }
        }
        System.out.println(sb);
    }
}