import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine(), " ");
        int[] array = new int[s + 1];
        for (int i = 1; i <= s; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int oddCount = 0;
        int evenCount = 0;
        int lt = 0;
        int answer = Integer.MIN_VALUE;

        for (int rt = 1; rt <= s; rt++) {
            if (array[rt] % 2 == 1) {
                oddCount++;
            }else{
                evenCount++;
            }
            while (oddCount > n) {
                lt++;
                if (array[lt] % 2 == 1) {
                    oddCount--;
                }else{
                    evenCount--;
                }
            }
            answer = Math.max(answer, evenCount);
        }
        System.out.println(answer);
    }
}