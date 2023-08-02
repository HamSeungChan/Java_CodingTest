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

        int[] array = new int[n + 1];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < array.length; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int[] sumArray = new int[n + 1];
        for (int i = 1; i < sumArray.length; i++) {
            sumArray[i] = sumArray[i - 1] + array[i];
        }
        
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int lt = Integer.parseInt(token.nextToken());
            int rt = Integer.parseInt(token.nextToken());

            System.out.println(sumArray[rt] - sumArray[lt - 1]);
        }


    }
}