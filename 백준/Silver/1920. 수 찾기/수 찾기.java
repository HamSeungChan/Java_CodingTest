import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }
        Arrays.sort(array);

        int m = sc.nextInt();
        long[] findArray = new long[m];
        for (int i = 0; i < m; i++) {
            findArray[i] = sc.nextLong();
        }

        for (long find : findArray) {
            int lt = 0;
            int rt = array.length - 1;
            int answer = 0;

            while (lt <= rt) {
                int middle = (lt + rt) / 2;
                if (array[middle] == find) {
                    answer = 1;
                    break;
                } else if (array[middle] > find) {
                    rt = middle - 1;
                } else {
                    lt = middle + 1;
                }
            }
            System.out.println(answer);
        }
    }
}
