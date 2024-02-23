import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        int lt = 0;
        int rt = array[array.length - 1] - array[0] + 1;

        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;

            if (call(mid) >= c) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        System.out.println(lt - 1);
    }

    public static int call(int distance) {

        int count = 1;
        int lastLocate = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] - lastLocate >= distance) {
                count++;
                lastLocate = array[i];
            }
        }
        return count;
    }

}