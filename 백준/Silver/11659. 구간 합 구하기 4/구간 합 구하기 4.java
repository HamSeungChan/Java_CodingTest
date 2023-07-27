import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sum[end] - sum[start-1]);
        }

    }
}