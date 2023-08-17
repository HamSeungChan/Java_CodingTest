import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] array;
	static int r, c;
	static int answer = 1;
	public static final int[] MOVE_X = { 1, 0, -1, 0 };
	public static final int[] MOVE_Y = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		r = Integer.parseInt(tmp[0]);
		c = Integer.parseInt(tmp[1]);

		array = new char[r][c];

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				array[i][j] = s.charAt(j);
			}
		}

	
		int size = 'Z'-'A';
		boolean[] check = new boolean[size + 1];
		

		check[array[0][0] - 'A'] = true;
		
		DFS(new Point(0, 0), 1, check);
		System.out.println(answer);
		

	}

	public static void DFS(Point p, int moveCount, boolean[] check) {

		for (int i = 0; i < MOVE_X.length; i++) {
			int moveX = p.x + MOVE_X[i];
			int moveY = p.y + MOVE_Y[i];

			if (checkValid(moveX, moveY) && !checkDuplicate(array[moveX][moveY], check)) {
				char c = array[moveX][moveY];

				moveCount++;
				answer = Math.max(answer, moveCount);
				check[c - 'A'] = true;
				DFS(new Point(moveX, moveY), moveCount, check);
				check[c - 'A'] = false;
				moveCount--;
			}
		}
	}

	public static boolean checkValid(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public static boolean checkDuplicate(char c, boolean[] check) {
		
		return check[c - 'A'];
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}