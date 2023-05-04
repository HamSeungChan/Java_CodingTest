import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> highM = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();

            int overPersonCount = p - l;

            if (overPersonCount < 0) {
                highM.add(1);
                for (int j = 0; j < p; j++) {
                    int garbage = sc.nextInt();
                }
            } else {
                int[] ms = new int[p];
                for (int j = 0; j < p; j++) {
                    ms[j] = sc.nextInt();
                }
                Arrays.sort(ms);
                highM.add(ms[overPersonCount]);
            }
        }

        Collections.sort(highM);
        for (int x : highM) {
            if(x>m) break;
            m -= x;
            answer++;
        }
        System.out.println(answer);
    }
}
