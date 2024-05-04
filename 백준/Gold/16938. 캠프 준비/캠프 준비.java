import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int answer = 0;
	static int n, l, r, x;
	static int[] array;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		l = Integer.parseInt(token.nextToken());
		r = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken());

		array = new int[n];

		token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}

		subset(0, 0, new boolean[n]);
		System.out.println(answer);
	}

	public static void subset(int index, int pickCount, boolean[] pick) {

		if (index == n) {

			if (pickCount < 2) {
				return;
			}

			int sum = 0;
			int minValue = Integer.MAX_VALUE;
			int maxValue = Integer.MIN_VALUE;
			for (int i = 0; i < pick.length; i++) {
				if (pick[i]) {
					sum += array[i];
					minValue = Math.min(minValue, array[i]);
					maxValue = Math.max(maxValue, array[i]);
				}
			}

			if (l <= sum && sum <= r && maxValue - minValue >= x) {
				answer++;
			}

		} else {

			pick[index] = true;
			subset(index + 1, pickCount + 1, pick);
			pick[index] = false;
			subset(index + 1, pickCount, pick);
		}

	}

}