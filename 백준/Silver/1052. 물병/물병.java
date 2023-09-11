import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(token.nextToken());
		int b = Integer.parseInt(token.nextToken());
		int answer = 0;
		int bottleSize = 1;

		PriorityQueue<Integer> q = new PriorityQueue<>();

		while (true) {
			if (a % 2 == 1) {
				q.offer(bottleSize);
				a = a - 1;
			}

			a /= 2;
			bottleSize *= 2;

			if (a == 0) {
				break;
			}
		}

//		while (!q.isEmpty()) {
//			System.out.println(q.poll());
//		}

		while (true) {
			if (q.size() <= b) {
				break;
			}
			int i = q.poll();
			int j = q.poll();
			answer += j - i;
			q.offer(j * 2);
		}

		System.out.println(answer);
	}
}