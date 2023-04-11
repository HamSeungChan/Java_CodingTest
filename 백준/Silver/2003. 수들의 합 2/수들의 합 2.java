
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(new Main().solution(a,m));
    }

    public int solution(int[] a, int m) {
        int answer = 0, lt = 0 , sum = 0;
        for(int rt =0 ; rt < a.length; rt++){
            sum += a[rt];
            if(sum == m) answer++;
            while(sum>=m){
                sum -= a[lt++];
                if(sum == m) answer++;
            }
        }
        return answer;
    }
}
