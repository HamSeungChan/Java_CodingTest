import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();
		int totalSum = 0;

		for (int i = 0; i < 10; i++) {
			int tmp = Integer.parseInt(br.readLine());
			totalSum += tmp;
			stack.push(tmp);
		}

		// 처음은 모두 더했을 떄
		int answer = totalSum;
		// 모두 더했을 떄 - 100
		int minDistance = totalSum - 100;

		for (int i = 0; i < 10; i++) {
			totalSum -= stack.pop();
			if (Math.abs(totalSum - 100) < minDistance) {
				answer = totalSum;
				minDistance = answer - 100;
			}
		}
		System.out.println(answer);
	}
}