import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] array;
	static int[] answer = { 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		array = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		check(0, 0, n);
		System.out.println(answer[0]);
		System.out.println(answer[1]);

	}

	public static void check(int startX, int startY, int size) {

		if (size == 1) {
			answer[array[startX][startY]]++;
			return;
		}

		int tmp = array[startX][startY];
		if (checkSameValue(startX, startY, tmp, size)) {
			answer[tmp]++;
		} else {
			check(startX, startY, size / 2);
			check(startX + size / 2, startY, size / 2);
			check(startX, startY + size / 2, size / 2);
			check(startX + size / 2, startY + size / 2, size / 2);
		}

	}

	public static boolean checkSameValue(int startX, int startY, int tmp, int size) {
		for (int i = startX; i < startX + size; i++) {
			for (int j = startY; j < startY + size; j++) {
				if (tmp != array[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}