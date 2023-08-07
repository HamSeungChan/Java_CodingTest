import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Info> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n + 1];

		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < array.length; i++) {

			int tmp = Integer.parseInt(token.nextToken());

			if (stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.push(new Info(i, tmp));
				continue;
			}

			if (stack.peek().value >= tmp) {
				sb.append(stack.peek().index).append(" ");
				stack.push(new Info(i, tmp));
			} else {
				while (true) {
					stack.pop();
					
					if (stack.isEmpty()) {
						sb.append(0).append(" ");
						stack.push(new Info(i,tmp));
						break;
					}
					
					if (stack.peek().value >= tmp) {
						sb.append(stack.peek().index).append(" ");
						stack.push(new Info(i,tmp));
						break;
					}
					
				}
			}

		}
		System.out.println(sb);
	}
}

class Info {
	int index;
	int value;

	public Info(int index, int value) {
		this.index = index;
		this.value = value;
	}

}