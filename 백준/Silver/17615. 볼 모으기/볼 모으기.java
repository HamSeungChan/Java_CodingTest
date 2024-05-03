import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] array = new int[n];
		String[] tmp = br.readLine().split("");
		for (int i = 0; i < n; i++) {
			if (tmp[i].equals("R")) {
				array[i] = 0;
			} else {
				array[i] = 1;
			}
		}

		// 파란색 오른쪽으로
		int redStartIndex = n - 1;
		for (int i = n - 1; i >= 0; i--) {
			if (array[i] == 0) {
				redStartIndex = i;
				break;
			}
		}

		int blueCount = 0;
		for (int i = redStartIndex; i >= 0; i--) {
			if (array[i] == 1) {
				blueCount++;
			}
		}
		// 파란색 왼쪽으로

		redStartIndex = 0;
		for (int i = redStartIndex; i < n; i++) {
			if (array[i] == 0) {
				redStartIndex = i;
				break;
			}
		}

		int blueCountToLeft = 0;
		for (int i = redStartIndex; i < n; i++) {
			if (array[i] == 1) {
				blueCountToLeft++;
			}
		}

		// 빨강색
		int blueStartIndex = n - 1;
		for (int i = blueStartIndex; i >= 0; i--) {
			if (array[i] == 1) {
				blueStartIndex = i;
				break;
			}
		}
		int redCount = 0;
		for (int i = blueStartIndex; i >= 0; i--) {
			if (array[i] == 0) {
				redCount++;
			}
		}

		// 빨강색 왼쪽으로

		blueStartIndex = 0;
		for (int i = blueStartIndex; i < n; i++) {
			if (array[i] == 1) {
				blueStartIndex = i;
				break;
			}
		}

		int redCountToLeft = 0;
		for (int i = blueStartIndex; i < n; i++) {
			if (array[i] == 0) {
				redCountToLeft++;
			}
		}

		System.out.println(Math.min(Math.min(Math.min(blueCount, redCount), blueCountToLeft), redCountToLeft));

	}
}