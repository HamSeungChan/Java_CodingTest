import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String[] array;
	static StringBuilder sb = new StringBuilder();
	static int n;
	static boolean flag;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		array = br.readLine().split(" ");

		flag = false;
		findFinalValue(new int[n + 1], 0, new boolean[10]);

		flag = false;
		findFirstValue(new int[n + 1], 0, new boolean[10]);

		System.out.print(sb);

	}

	public static void findFirstValue(int[] pick, int index, boolean[] check) {

		if (flag) {
			return;
		}
		if (index == n + 1) {
			for (int i : pick) {
				sb.append(i);
			}
			flag = true;
		} else {
			for (int i = 0; i <= 9; i++) {
				if (index == 0) {
					pick[index] = i;
					check[i] = true;
					findFirstValue(pick, index + 1, check);
					check[i] = false;
				} else {

					if (check[i]) {
						continue;
					}

					if (array[index - 1].equals(">") && pick[index - 1] <= i) {
						continue;
					}
					if (array[index - 1].equals("<") && pick[index - 1] >= i) {
						continue;
					}

					pick[index] = i;
					check[i] = true;
					findFirstValue(pick, index + 1, check);
					check[i] = false;
				}
			}
		}
	}

	public static void findFinalValue(int[] pick, int index, boolean[] check) {

		if (flag) {
			return;
		}

		if (index == n + 1) {
			for (int i : pick) {
				sb.append(i);
			}
			sb.append("\n");
			flag = true;
		} else {
			for (int i = 9; i >= 0; i--) {
				if (index == 0) {
					pick[index] = i;
					check[i] = true;
					findFinalValue(pick, index + 1, check);
					check[i] = false;
				} else {

					if (check[i]) {
						continue;
					}

					if (array[index - 1].equals(">") && pick[index - 1] <= i) {
						continue;
					}
					if (array[index - 1].equals("<") && pick[index - 1] >= i) {
						continue;
					}

					pick[index] = i;
					check[i] = true;
					findFinalValue(pick, index + 1, check);
					check[i] = false;
				}
			}
		}
	}
}