import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] array = new String[n];
		for (int i = 0; i < n; i++) {
			array[i] = br.readLine();
		}

		Arrays.sort(array, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub

				if (o1.length() == o2.length()) {
					int sum1 = 0;
					int sum2 = 0;

					for (char c : o1.toCharArray()) {
						if (Character.isDigit(c)) {
							sum1 += c - '0';
						}
					}

					for (char c : o2.toCharArray()) {
						if (Character.isDigit(c)) {
							sum2 += c - '0';
						}
					}

					if (sum1 == sum2) {
						return o1.compareTo(o2);
					}

					return sum1 - sum2;
				}

				return o1.length() - o2.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String s : array) {
			sb.append(s).append("\n");
		}
		System.out.print(sb);

	}
}