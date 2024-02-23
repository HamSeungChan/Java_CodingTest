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

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(token.nextToken());
            sb.append(upperBound(tmp, array) - lowerBound(tmp, array)).append(" ");
        }

        System.out.println(sb);
    }


    // 하향선
    public static int lowerBound(int key, int[] array) {

        int lo = 0;
        int hi = array.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key <= array[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }


    // 상향선
    public static int upperBound(int key, int[] array) {
        int lo = 0;
        int hi = array.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < array[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}