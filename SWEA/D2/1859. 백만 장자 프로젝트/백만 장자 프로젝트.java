import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();

        for (int i = 0; i < testCount; i++) {
            int day = sc.nextInt();
            int[] value = new int[day];

            for (int j = 0; j < day; j++) {
                value[j] = sc.nextInt();
            }

            long sum = 0;
            int max = Integer.MIN_VALUE;
            for(int j = day -1; j>=0;j--){
                if(value[j] > max) {
                    max = value[j];
                }
                else{
                    sum += max - value[j];
                }
            }
            int testNumber = i+1;
            System.out.println("#"+testNumber+" "+sum);
        }
    }
}
