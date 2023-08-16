import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[] array;
	static boolean[] leftCross;
	static boolean[] rightCross;
	static int answer;
	static int size;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		array = new int[n + 1];
		answer = 0;
		leftCross = new boolean[2 * n - 1];
		rightCross = new boolean[2 * n - 1];
		size = n - 1;

		setQueen(1);
		System.out.println(answer);
	}

	public static void setQueen(int row) {

		if (row > n) {
			answer++;
			return;
		}

		for (int c = 1; c <= n; c++) {

			if (isAvailable(row, c)) {
				leftCross[row - c + size] = true;
				rightCross[row + c - 2] = true;
				
				array[row] = c;
				setQueen(row + 1);
				
				rightCross[row + c - 2] = false;
				leftCross[row - c + size] = false;
			}
		}
	}

	public static boolean isAvailable(int row, int c) {

		for (int i = 1; i < row; i++) {
			if (array[i] == c || leftCross[row - c + size] == true || rightCross[row + c - 2] == true) {
				return false;
			}
		}
		return true;
	}

}