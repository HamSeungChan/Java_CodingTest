import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] array;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		array = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		check(0,0,n);
		System.out.print(sb);

	}

	public static void check(int startX, int startY, int n) {

		

		int tmp = array[startX][startY];
		int sum = 0;
		for (int i = startX; i < startX + n; i++) {
			for (int j = startY; j < startY + n; j++) {
				sum += array[i][j];
			}
		}

		if (tmp * n * n != sum) {

			int newSize = n / 2;
			
			sb.append("(");
			for (int i = startX; i < startX + n; i += newSize) {
				for (int j = startY; j < startY + n; j += newSize) {
					
					check(i, j, newSize);
					
				}
			}
			sb.append(")");

		} else {
			sb.append(tmp);
		}

		

	}

}