import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;
        int[] checkArray = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        checkArray[n] = 1;
        int count = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                int tmp = q.poll();
                if (tmp == k) {
                    answer = count;
                    q.clear();
                    break;
                }
                if (tmp + 1 < checkArray.length) {
                    if (checkArray[tmp + 1] == 0) {
                        q.offer(tmp + 1);
                        checkArray[tmp + 1] = 1;
                    }
                }
                if (tmp - 1 >= 0) {
                    if (checkArray[tmp - 1] == 0) {
                        q.offer(tmp - 1);
                        checkArray[tmp - 1] = 1;
                    }
                }

                if (tmp * 2 < checkArray.length) {
                    if (checkArray[tmp * 2] == 0) {
                        q.offer(tmp * 2);
                        checkArray[tmp * 2] = 1;
                    }
                }

            }
            count++;
        }
        System.out.println(answer);
    }
}
