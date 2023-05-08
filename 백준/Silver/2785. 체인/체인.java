import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        int necessaryLink = n - 1;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int index = 0;

        if (necessaryLink == 1) {
            answer = 1;
        } else {
            while (true) {
                if (necessaryLink < 1) {
                    break;
                }
                array[index] -= 1;
                necessaryLink -= 1;
                if (array[index] == 0) {
                    necessaryLink--;
                    index++;
                }
                answer++;
            }
        }
        System.out.println(answer);
    }
}
