import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			q.offer(Integer.parseInt(br.readLine()));
		}

		int answer = 0;
		while (q.size() >= 2) {
			int firstNumber = q.poll();
			int secondNumber = q.poll();
			int value = firstNumber + secondNumber;
			answer += value;
			q.offer(value);
		}
		System.out.println(answer);
	}
}