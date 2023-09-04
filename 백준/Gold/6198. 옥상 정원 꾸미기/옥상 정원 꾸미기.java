import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Info> stack = new Stack<>();
		long answer = 0;
		for (int i = 1; i <= n; i++) {

			long height = Integer.parseInt(br.readLine());

			if (stack.isEmpty()) {
				stack.push(new Info(i, height));
				continue;
			}

			while (stack.peek().height <= height) {
				Info info = stack.pop();
				answer += (i - info.time - 1);
				if (stack.isEmpty()) {
					break;
				}
			}
			stack.push(new Info(i, height));
		}
		
		while(!stack.isEmpty()) {
			Info info = stack.pop();
			answer += n - info.time;
		}
		
		System.out.println(answer);

	}
}

class Info {
	int time;
	long height;

	Info(int time, long height) {
		this.time = time;
		this.height = height;
	}
}