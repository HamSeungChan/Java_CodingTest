import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] array;
	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}
		recursion(new int[10], 0, 0, 0);
		System.out.println(answer);
	}

	public static void recursion(int[] pick, int index, int bb, int b) {

		if (index == 10) {
			int count = 0;
			for (int i = 0; i < 10; i++) {
				if (pick[i] == array[i]) {
					count++;
				}
			}
			if (count >= 5) {
				answer++;
			}
			return;
		}

		for (int i = 1; i <= 5; i++) {

			if (index == 0) {
				pick[index] = i;
				recursion(pick, index + 1, -1, i);
			} else if (index == 1) {
				pick[index] = i;
				recursion(pick, index + 1, b, i);
			} else {
				if (bb == b && b == i) {
					continue;
				}
				pick[index] = i;
				recursion(pick, index + 1, b, i);
			}
		}

	}

}