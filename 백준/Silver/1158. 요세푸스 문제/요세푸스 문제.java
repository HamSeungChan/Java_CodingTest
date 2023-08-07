import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);

		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			q.offerLast(i);
		}

		int cnt = 0;
		int plusCount = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		while (!q.isEmpty()) {

			int tmp = q.pollFirst();
			cnt++;

			if (cnt == k) {
				
				if(plusCount == n-1) {
					sb.append(tmp).append(">");
				}else {
					sb.append(tmp).append(",").append(" ");
					plusCount++;
					cnt = 0;
				}
				
			} else {
				q.offerLast(tmp);
			}

		}
		System.out.println(sb);
	}
}