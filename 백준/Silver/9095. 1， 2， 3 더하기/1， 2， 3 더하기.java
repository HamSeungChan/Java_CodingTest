import java.util.Scanner;

public class Main {

    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] testCase = new int[n];
        for (int i = 0; i < n; i++) {
            testCase[i] = sc.nextInt();
        }
        for (int x : testCase) {
            answer = 0;
            new Main().DFS(0, x);
            System.out.println(answer);
        }
    }

    public void DFS(int sum, int x) {
        if (sum > x) return;
        if (sum == x) {
            answer++;
        } else {
            for (int i = 1; i <= 3; i++) {
                sum += i;
                DFS(sum, x);
                sum -= i;
            }
        }
    }

}
