import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Integer> sumList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() * 2;
        int[] students = new int[n];

        for (int i = 0; i < n; i++) {
            students[i] = sc.nextInt();
        }

        Arrays.sort(students);

        for (int i = 0; i < n / 2; i++) {
            sumList.add(students[i] + students[n - i - 1]);
        }

        System.out.println(sumList
                .stream()
                .mapToInt(x -> x)
                .min()
                .getAsInt());
    }
}