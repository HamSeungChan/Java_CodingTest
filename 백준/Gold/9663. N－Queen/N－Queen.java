import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[] array;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		answer = 0;
		array = new int[n + 1];
		
		setQuuen(1);
		System.out.println(answer);
	}

	public static void setQuuen(int row) {

		if (!isAvailable(row - 1)) {
			return;
		}

		if (row > n) {
			answer++;
			return;
		}

		for (int c = 1; c <= n; c++) {
			array[row] = c;
			setQuuen(row + 1);
		}

	}

	public static boolean isAvailable(int row) {

		for (int i = 1; i < row; i++) {
			if (array[i] == array[row] || row - i == Math.abs(array[i] - array[row])) {
				return false;
			}
		}

		return true;
	}

}