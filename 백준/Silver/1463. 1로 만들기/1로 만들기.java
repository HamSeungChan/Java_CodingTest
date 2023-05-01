import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new Main().BFS(n));
    }

    public int BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                if(tmp ==1 ) return level;
                if (tmp % 3 == 0) q.offer(tmp / 3);
                if (tmp % 2 == 0) q.offer(tmp / 2);
                q.offer(tmp - 1);
            }
            level++;
        }
        return -1;
    }

}
