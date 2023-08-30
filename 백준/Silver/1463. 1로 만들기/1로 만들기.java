import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(BFS(n));
    }

    public static int BFS(int n) {
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