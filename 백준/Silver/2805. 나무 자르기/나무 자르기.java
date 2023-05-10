import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long answer = 0;
        int n = sc.nextInt();
        long m = sc.nextInt();
        long[] tree = new long[n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = sc.nextLong();
        }
        Arrays.sort(tree);

        long lt = 0;
        long rt = tree[tree.length - 1];

        while (lt <= rt) {
            long middle = (lt + rt) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (tree[i] - middle > 0) {
                    sum += tree[i] - middle;
                }
            }
            if (sum == m) {
                answer = middle;
                break;
            } else if (sum > m) {
                answer = middle;
                lt = middle + 1;
            } else {
                rt = middle - 1;
            }
        }
        System.out.println(answer);
    }
}
