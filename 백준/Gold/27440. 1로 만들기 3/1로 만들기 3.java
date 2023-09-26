import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(bfs(n));

    }

    private static int bfs(long n) {

        Set<Long> set = new HashSet<>();
        Queue<Long> q = new LinkedList<>();
        q.offer(n);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long tmp = q.poll();

                if (tmp == 1) {
                    return level;
                }

                if (tmp % 3 == 0 && !set.contains(tmp / 3)) {
                    set.add(tmp / 3);
                    q.offer(tmp / 3);
                }
                if (tmp % 2 == 0 && !set.contains(tmp / 2)) {
                    set.add(tmp / 2);
                    q.offer(tmp / 2);
                }
                if (!set.contains(tmp - 1)) {
                    set.add(tmp - 1);
                    q.offer(tmp - 1);
                }

            }
            level++;
        }
        return 0;
    }
}