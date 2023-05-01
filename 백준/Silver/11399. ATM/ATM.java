import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int time = 0;
        Arrays.sort(array);
        for(int x : array){
            answer += time+x;
            time += x;
        }
        System.out.println(answer);
    }
}