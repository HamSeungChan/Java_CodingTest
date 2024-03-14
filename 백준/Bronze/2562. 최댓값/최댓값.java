import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int maxValue = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 1; i <= 9; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > maxValue) {
				maxValue = n;
				maxIndex = i;
			}
		}
		System.out.println(maxValue);
		System.out.println(maxIndex);
	}
}