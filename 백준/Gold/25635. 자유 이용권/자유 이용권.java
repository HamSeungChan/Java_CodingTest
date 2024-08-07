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

        long totalSize = 0;
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(token.nextToken());
            totalSize += tmp;
            array[i] = tmp;
        }

        Arrays.sort(array);

        long firstSize = array[n - 1];
        if (firstSize - 1 <= totalSize - firstSize) {
            System.out.println(totalSize);
        } else {
            System.out.println(totalSize - firstSize + totalSize - firstSize + 1);
        }
    }

}