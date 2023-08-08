import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i =0; i< n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp != 0) {
				q.offer(tmp);
				continue;
			}
			
			if(q.isEmpty()) {
				sb.append(0).append("\n");
			}else {
				sb.append(q.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}
}