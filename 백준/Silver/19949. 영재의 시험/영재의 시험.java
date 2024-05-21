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
		recursion(0, 0, 0, 0);
		System.out.println(answer);
	}

	public static void recursion(int index, int bb, int b, int score) {

		if (index == 10) {
			if (score >= 5) {
				answer++;
			}
			return;
		}

		for (int i = 1; i <= 5; i++) {
			if (bb == b && b == i)
				continue;
			recursion(index + 1, b, i, score + (i == array[index] ? 1 : 0));
		}

	}

}