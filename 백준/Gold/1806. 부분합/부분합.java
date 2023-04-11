import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int lt = 0, sum = 0, answer = Integer.MAX_VALUE;
        for (int rt = 0; rt < n; rt++) {
            sum += array[rt];
            if (sum >= m) answer = Math.min(rt - lt, answer);
            while (sum >= m) {
                sum -= array[lt++];
                if (sum >= m) answer = Math.min(rt - lt, answer);
            }
        }
        if(answer == Integer.MAX_VALUE){
            System.out.println(0);
        }
        else 
            System.out.println(answer + 1);
    }
}
