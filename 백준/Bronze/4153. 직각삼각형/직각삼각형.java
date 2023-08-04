import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] array = new int[3];
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            array[0] = Integer.parseInt(token.nextToken());
            array[1] = Integer.parseInt(token.nextToken());
            array[2] = Integer.parseInt(token.nextToken());

            if (array[0] == 0 && array[1] == 0 && array[2] == 0) {
                break;
            }

            Arrays.sort(array);
            
            if (array[2] * array[2] == array[1] * array[1] + array[0] * array[0]) {
                sb.append("right").append("\n");
                continue;
            }

            sb.append("wrong").append("\n");
        }
        System.out.println(sb);
    }
}