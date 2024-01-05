import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        boolean[] array = new boolean[10_001];
        array[0] = array[1] = true;
        for (int i = 2; i <= Math.sqrt(array.length); i++) {
            if (!array[i]) {
                for (int j = i * i; j < array.length; j += i) {
                    array[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int tmp = Integer.parseInt(br.readLine());
            int x = 0, y = 0;
            for (int j = 2; j <= tmp / 2; j++) {
                if (!array[j] && !array[tmp - j]) {
                    x = j;
                    y = tmp - j;
                }
            }
            sb.append(x).append(" ").append(y).append("\n");
        }
        System.out.println(sb);
    }
}