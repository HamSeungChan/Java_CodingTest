import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] expectedScore = new int[n];
        for(int i=0;i<n;i++){
            expectedScore[i] = sc.nextInt();
        }
        Arrays.sort(expectedScore);
        long sum = 0;
        for(int i=0; i<n;i++){
            sum +=Math.abs((i+1) - expectedScore[i]) ;
        }
        System.out.println(sum);
    }
}