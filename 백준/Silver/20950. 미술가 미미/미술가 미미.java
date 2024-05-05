import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static RGB[] array;
	static RGB gomColor;
	static int n, answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		array = new RGB[n];

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			array[i] = new RGB(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),
				Integer.parseInt(token.nextToken()));
		}

		token = new StringTokenizer(br.readLine(), " ");
		gomColor = new RGB(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),
			Integer.parseInt(token.nextToken()));

		for (int i = 2; i <= 7; i++) {
			comb(0, 0, i, new int[i]);
		}

		System.out.println(answer);
	}

	public static void comb(int index, int start, int lastIndex, int[] pick) {

		if (index == lastIndex) {

			RGB sum = new RGB(0, 0, 0);
			for (int i : pick) {
				sum.r += array[i].r;
				sum.g += array[i].g;
				sum.b += array[i].b;
			}

			sum.r /= lastIndex;
			sum.g /= lastIndex;
			sum.b /= lastIndex;

			answer = Math.min(answer,
				Math.abs(gomColor.r - sum.r) + Math.abs(gomColor.g - sum.g) + Math.abs(gomColor.b - sum.b));

		} else {
			for (int i = start; i < n; i++) {
				pick[index] = i;
				comb(index + 1, i + 1, lastIndex, pick);
			}
		}

	}

}

class RGB {
	int r;
	int g;
	int b;

	public RGB(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
}