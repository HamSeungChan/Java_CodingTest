import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            int cost = coin[i];
            answer += k / cost;
            k = k % cost;
        }
        System.out.println(answer);
    }
}
