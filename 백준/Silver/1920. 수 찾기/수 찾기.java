import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(array);
        int find = Integer.parseInt(br.readLine());
        int[] answer = new int[find];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < find; i++) {
            answer[i] = Integer.parseInt(token.nextToken());
        }

        for (int x : answer) {
            int lt = 0;
            int rt = array.length - 1;
            int print = 0;
            while (lt <= rt) {
                int middle = (lt + rt) / 2;
                if (array[middle] == x) {
                    print = 1;
                    break;
                } else if (array[middle] > x) {
                    rt = middle - 1;
                } else {
                    lt = middle + 1;
                }
            }
            System.out.println(print);
        }


    }
}