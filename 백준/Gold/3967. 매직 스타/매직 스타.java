import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static boolean flag;
	static boolean[] fix;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] array = new int[12];
		boolean[] use = new boolean['Z' - 'A'];
		fix = new boolean[12];

		int index = 0;
		for (int i = 0; i < 5; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				if (tmp[j] != '.') {
					if (tmp[j] != 'x') {
						use[tmp[j] - 'A'] = true;
						array[index] = tmp[j] - 'A';
						fix[index] = true;
					}
					index++;
				}
			}
		}

		permutation(0, use, array);
		System.out.print(sb);

	}

	public static void permutation(int index, boolean[] use, int[] array) {

		if (flag) {
			return;
		}

		if (index == 12) {

			if (isMagicStar(array)) {

				flag = true;

				char[] answer = new char[12];
				for (int i = 0; i < 12; i++) {
					answer[i] = (char)(array[i] + 'A');
				}

				sb.append(".")
					.append(".")
					.append(".")
					.append(".")
					.append(answer[0])
					.append(".")
					.append(".")
					.append(".")
					.append(".")
					.append("\n");
				sb.append(".")
					.append(answer[1])
					.append(".")
					.append(answer[2])
					.append(".")
					.append(answer[3])
					.append(".")
					.append(answer[4])
					.append(".")
					.append("\n");
				sb.append(".")
					.append(".")
					.append(answer[5])
					.append(".")
					.append(".")
					.append(".")
					.append(answer[6])
					.append(".")
					.append(".")
					.append("\n");
				sb.append(".")
					.append(answer[7])
					.append(".")
					.append(answer[8])
					.append(".")
					.append(answer[9])
					.append(".")
					.append(answer[10])
					.append(".")
					.append("\n");
				sb.append(".")
					.append(".")
					.append(".")
					.append(".")
					.append(answer[11])
					.append(".")
					.append(".")
					.append(".")
					.append(".");
			}

		} else {

			if (fix[index]) {
				permutation(index + 1, use, array);
			} else {
				for (int i = 0; i <= 11; i++) {
					if (!use[i]) {
						use[i] = true;
						array[index] = i;
						permutation(index + 1, use, array);
						use[i] = false;
					}
				}
			}
		}
	}

	public static boolean isMagicStar(int[] array) {

		int a = array[0] + array[2] + array[5] + array[7];
		int b = array[0] + array[3] + array[6] + array[10];
		int c = array[1] + array[2] + array[3] + array[4];
		int d = array[7] + array[8] + array[9] + array[10];
		int e = array[1] + array[5] + array[8] + array[11];
		int f = array[4] + array[6] + array[9] + array[11];
        
		Set<Integer> set = new HashSet<>(Arrays.asList(a, b, c, d, e, f));
		return set.size() == 1;

	}

}