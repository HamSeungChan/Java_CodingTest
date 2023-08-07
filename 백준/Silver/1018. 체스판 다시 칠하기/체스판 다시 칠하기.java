import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean[][] array;
	static int SIZE = 8;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		array = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				if (tmp[j].equals("W")) {
					array[i][j] = true;
				} else {
					array[i][j] = false;
				}
			}
		}

		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i <= array.length - SIZE; i++) {
			for (int j = 0; j <= array[0].length - SIZE; j++) {
				answer = Math.min(answer, check(i, j));
			}
		}
		System.out.println(answer);

	}

	public static int check(int startX, int startY) {
		boolean tmp = array[startX][startY];
		int count = 0;
		for (int i = startX; i < startX + SIZE; i++) {
			for (int j = startY; j < startY + SIZE; j++) {
				if (tmp != array[i][j]) {
					count++;
				}
				tmp = !tmp;
			}
			tmp = !tmp;
		}

		return Math.min(count, 64 - count);
	}
}