import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder("<");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int count = 0;

        while (!deque.isEmpty()) {
            count++;
            int tmp = deque.pollFirst();
            if (count == k) {
                if (sb.length() == 1) {
                    sb.append(tmp);
                }else{
                    sb.append(",").append(" ").append(tmp);
                }
                count = 0;
                continue;
            }
            deque.offerLast(tmp);
        }
        System.out.println(sb.append(">"));
    }
}