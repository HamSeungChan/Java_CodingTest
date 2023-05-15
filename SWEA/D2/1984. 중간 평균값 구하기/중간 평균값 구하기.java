import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            int [] array = new int[10];
            for(int i=0; i< array.length;i++){
                array[i] = sc.nextInt();
            }
            Arrays.sort(array);
            double sum = 0;
            for(int i = 1; i< array.length-1;i++){
                sum += array[i];
            }
            System.out.println("#"+test+" "+Math.round(sum/8));
        }
    }
}
