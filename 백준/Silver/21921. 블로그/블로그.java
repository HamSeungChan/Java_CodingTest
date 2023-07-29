import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();


        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = new int[n];
        int answer;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
            if (i < x) {
                sum += array[i];
            }
        }
        map.put(sum, map.getOrDefault(sum,0)+1);
        answer = sum;


        for (int i = x; i < n; i++) {
            sum += (array[i] - array[i - x]);
            map.put(sum, map.getOrDefault(sum,0)+1);
            answer = Math.max(answer, sum);
        }

        if (answer == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(answer);
            System.out.println(map.get(answer));
        }
    }
}