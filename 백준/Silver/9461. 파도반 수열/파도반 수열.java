import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int test = sc.nextInt();
        long [] answer = new long[test];
        for(int i=0; i<test;i++){
            int n = sc.nextInt();
            long [] dp = new long[n];
            if(dp.length<=3){
                answer[i] =1;
                continue;
            }
            if(dp.length<=5){
                answer[i] =2;
                continue;
            }

            dp[0] =1;
            dp[1] =1;
            dp[2] =1;
            dp[3] =2;
            dp[4] =2;
            int pick = 0;
            for(int j= 5 ; j<n;j++){
                dp[j] = dp[j-1] + dp[pick++];
            }
            answer[i] = dp[n-1];
        }
        for(long x : answer){
            System.out.println(x);
        }
    }
}
