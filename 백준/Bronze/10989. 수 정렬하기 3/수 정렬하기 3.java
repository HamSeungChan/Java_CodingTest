import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] array = new int[10000001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            array[Integer.parseInt(br.readLine())]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < array.length; i++) {
            if (array[i] > 0) {
                for (int j = 0; j < array[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}