import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] array;
	static int totalSum = 0;
	static StringBuilder sb = new StringBuilder();
	static boolean flag;

	public static void main(String[] args) throws IOException {

		array = new int[9];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		totalSum = 0;
		for (int i = 0; i < 9; i++) {
			totalSum += array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);
		comb(0, new boolean[9], 0);
		System.out.println(sb);
	}

	public static void comb(int index, boolean[] check, int sum) {

		if (flag) {
			return;
		}

		if (index == 2) {
			if (totalSum - sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (!check[i]) {
						sb.append(array[i]).append("\n");
					}
				}
				flag = true;
			}
		} else {
			for (int i = 0; i < 9; i++) {
				if (!check[i]) {
					check[i] = true;
					comb(index + 1, check, sum + array[i]);
					check[i] = false;
				}
			}
		}
	}
}