import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[] array;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        array = new int[n];
        check = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        new Main().DFS(0, 0, new int[m]);
    }

    public void DFS(int value, int start, int[] answer) {
        if (value == m) {
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < array.length; i++) {
                if (check[i] == 0) {
                    answer[value] = array[i];
                    check[i] = 1;
                    DFS(value + 1, i + 1, answer);
                    check[i] = 0;
                }
            }
        }
    }
}
