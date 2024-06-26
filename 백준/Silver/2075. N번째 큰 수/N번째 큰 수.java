import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n * n];
        StringTokenizer token;
        int index = 0;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j <n ; j++){
                array[index++] = Integer.parseInt(token.nextToken());
            }
        }
        Arrays.sort(array);
        System.out.println(array[n * n - n]);
    }
}