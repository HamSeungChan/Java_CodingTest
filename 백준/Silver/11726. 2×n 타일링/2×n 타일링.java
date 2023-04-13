import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[1001];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++){
            array[i] = (array[i-2] + array[i-1])% 10007 ;
        }
        System.out.println(array[n]);
    }
}
