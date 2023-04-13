import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        for (int rt = 1; rt < n; rt++) {
            int lt = 0;
            int sum = array[lt] + array[rt];
            if (sum == m) answer++;
            while (sum < m && lt < rt-1) {
                lt++;
                sum = array[lt] + array[rt];
                if (sum == m) answer++;
            }
        }
        System.out.println(answer);
    }
}
