import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		m = Integer.parseInt(br.readLine());
		int index = findMinIndex(array, 1);
		if (n == 1 || m < array[index]) {
			System.out.println(0);
		} else {
			
			// 첫 번째 값을 붙인다
			sb.append(index);
			m -= array[index];
			
			index = findMinIndex(array, 0);
			while (true) {
				if (m - array[index] >= 0) {
					sb.append(index);
					m -= array[index];
				} else {
					break;
				}
			}

			String[] s = sb.toString().split("");

			for (int i = 0; i < s.length; i++) { // 자릿수

				for (int j = Integer.parseInt(s[i]) + 1; j < array.length; j++) { // 현재 값의 다음 수 확인
					int tmp = array[j] - array[Integer.parseInt(s[i])];
					if (m >= tmp) {
						s[i] = String.valueOf(j);
						m -= tmp;
					}
				}
			}

			for (String ss : s) {
				System.out.print(ss);
			}
		}

	}

	public static int findMinIndex(int[] array, int startPoint) {
		int minValueIndex = startPoint;
		for (int i = startPoint; i < array.length; i++) {
			if (array[minValueIndex] >= array[i]) {
				minValueIndex = i;
			}
		}
		return minValueIndex;
	}

}