import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] array = new int[101][101];
		int n = Integer.parseInt(br.readLine());
		for (int p = 0; p < n; p++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					array[i][j] = 1;
				}
			}
		}

		int count = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (array[i][j] == 1) {
					count++;
				}

			}
		}
		System.out.println(count);
	}
}