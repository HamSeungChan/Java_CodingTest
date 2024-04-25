import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
					continue;
				}
				sb.append(pq.poll()).append("\n");
				continue;
			}
			pq.offer(tmp);
		}
		System.out.println(sb);
	}
}