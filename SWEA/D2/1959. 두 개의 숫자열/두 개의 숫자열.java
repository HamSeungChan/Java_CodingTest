import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int max = Integer.MIN_VALUE;

            int arrayN[] = new int[n];
            int arrayM[] = new int[m];

            for (int i = 0; i < n; i++) {
                arrayN[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                arrayM[i] = sc.nextInt();
            }

            if (n >= m) {
                for(int i=0; i<= n-m;i++){
                    int [] tmp = Arrays.copyOfRange(arrayN,i,i+m);
                    int sum = 0;
                    for(int j=0;j<tmp.length;j++){
                        sum += tmp[j]*arrayM[j];
                    }
                    max = Math.max(max,sum);
                }
            }
            else {
                for(int i=0; i<= m-n;i++){
                    int [] tmp = Arrays.copyOfRange(arrayM,i,i+n);
                    int sum = 0;
                    for(int j=0;j<tmp.length;j++){
                        sum += tmp[j]*arrayN[j];
                    }
                    max = Math.max(max,sum);
                }
            }

            System.out.println("#"+t+" "+max);

        }
    }
}
