import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			set.add(tmp);
			array[i] = tmp;
		}

		int maxLength = 0;
		for (Integer i : set) {

			int value = 0;
			int length = 0;

			int j;
			for (j = 0; j < array.length; j++) {
				if (array[j] != i) {
					value = array[j];
					break;
				}
			}

			for (; j < array.length; j++) {

				if (array[j] == i)
					continue;

				if (value == array[j]) {
					length++;
					maxLength = Math.max(maxLength, length);
				} else {
					value = array[j];
					length = 1;
				}
			}
		}
		System.out.println(maxLength);
	}
}