import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] array = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (array[i] == 0) {
                for (int j = i; j <= n; j +=i) {
                    array[j] = 1;
                }
                if (i >= m) {
                    System.out.println(i);
                }
            }
        }
    }
}