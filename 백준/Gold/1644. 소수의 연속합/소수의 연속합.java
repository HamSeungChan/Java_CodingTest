import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int[] array = new int[n + 1];
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (array[i] == 0) {
                list.add(i);
                for (int j = i; j <= n; j = i + j){
                    array[j] = 1;
                }
            }
        }
        int lt = 0, sum = 0;
        for (int rt : list) {
            sum += rt;
            if (sum == n) count++;
            while (sum >= n) {
                sum -= list.get(lt++);
                if (sum == n) count++;
            }
        }
        System.out.println(count);
    }
}