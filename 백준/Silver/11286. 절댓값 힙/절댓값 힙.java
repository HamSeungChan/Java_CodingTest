import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }

                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp != 0) {
                pq.offer(tmp);
                continue;
            }

            if(pq.size() == 0){
                sb.append(0).append("\n");
                continue;
            }

            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}