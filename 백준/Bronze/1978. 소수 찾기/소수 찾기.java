import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[1001];
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            if (array[i] == 0) {
                for (int j = i+i; j < array.length; j += i) {
                    array[j] = 1;
                }
            }
        }
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(array[Integer.parseInt(token.nextToken())] == 0){
                sum ++;
            }
        }
        System.out.println(sum);
    }
}