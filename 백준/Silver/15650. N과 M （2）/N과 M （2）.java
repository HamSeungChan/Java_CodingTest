import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] nArray = new int[n];
        for (int i = 0; i < n; i++) {
            nArray[i] = i + 1;
        }
        array = new int[m];

        new Main().DFS(nArray, 0, 0);
    }

    public void DFS(int[] nArray, int start, int value) {

        if (value == m) {
            for (int x : array) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < n; i++) {
                array[value] = nArray[i];
                DFS(nArray, i + 1, value + 1);
            }
        }
    }
}
