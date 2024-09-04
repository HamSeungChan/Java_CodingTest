import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int findValue = Integer.parseInt(token.nextToken());
            sb.append(find(findValue) ? 1 : 0).append(" ");
        }
        System.out.print(sb);
    }

    public static boolean find(int findValue) {

        int lt = 0;
        int rt = n - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (array[mid] > findValue) {
                rt = mid - 1;
            } else if (array[mid] < findValue) {
                lt = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}