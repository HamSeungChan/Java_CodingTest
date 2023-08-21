import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] MOVE_X = { -1, 0, 1, 0 };
	public static int[] MOVE_Y = { 0, 1, 0, -1 };

	static int r, c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(token.nextToken());
		c = Integer.parseInt(token.nextToken());
		int t = Integer.parseInt(token.nextToken());

		int[][] array = new int[r][c];
		Point[] airCleanMachine = new Point[2];
		int location = 0;
		for (int i = 0; i < r; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
				if (array[i][j] == -1) {
					airCleanMachine[location++] = new Point(i, j);
				}
			}
		}

		for (int i = 0; i < t; i++) {
			// 미세먼지 확산
			array = spreadDust(array);
			// 공기 청정기 작동
			array = airCleanTop(array, airCleanMachine[0]);
			array = airCleanBottom(array, airCleanMachine[1]);
		}
		
		int answer = 0;
		
		for (int i = 0; i < r; i++) {
	
			for (int j = 0; j < c; j++) {
				if (array[i][j] > 0) {
					answer += array[i][j];
				}
			}
		}
		
		System.out.println(answer);

	}

	public static int[][] airCleanTop(int[][] array, Point p) {
		int moveCount = (p.x + 1 + c) * 2 - 4 - 1;
		int x = p.x - 1;
		int y = p.y;
		int direction = 0;
		for (int i = 0; i < moveCount; i++) {
			int newX = x + MOVE_X[direction];
			int newY = y + MOVE_Y[direction];

			if (isTopValid(newX, newY, p)) {
				if (array[newX][newY] == -1) {
					array[x][y] = 0;
				} else {
					array[x][y] = array[newX][newY];
				}
			} else {
				direction++;
				newX = x + MOVE_X[direction];
				newY = y + MOVE_Y[direction];
				array[x][y] = array[newX][newY];
			}
			x = newX;
			y = newY;
		}
		return array;
	}

	public static int[][] airCleanBottom(int[][] array, Point p) {
		int moveCount = (r - p.x + c) * 2 - 4 - 1;
		int x = p.x + 1;
		int y = p.y;
		int direction = 2;

		for (int i = 0; i < moveCount; i++) {
			int newX = x + MOVE_X[direction];
			int newY = y + MOVE_Y[direction];

			if (isbottomValid(newX, newY, p)) {
				if (array[newX][newY] == -1) {
					array[x][y] = 0;
				} else {
					array[x][y] = array[newX][newY];
				}
			} else {
				direction--;
				if (direction == -1) {
					direction = 3;
				}
				newX = x + MOVE_X[direction];
				newY = y + MOVE_Y[direction];
				array[x][y] = array[newX][newY];
			}

			x = newX;
			y = newY;
		}
		return array;
	}

	public static int[][] spreadDust(int[][] array) {
		int[][] spreadArray = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (array[i][j] > 4) {
					int spreadValue = array[i][j] / 5;
					int spreadCount = 0;
					for (int k = 0; k < MOVE_X.length; k++) {
						int moveX = i + MOVE_X[k];
						int moveY = j + MOVE_Y[k];
						if (isValid(moveX, moveY) && array[moveX][moveY] != -1) {
							spreadArray[moveX][moveY] += spreadValue;
							spreadCount++;
						}
					}
					spreadArray[i][j] += array[i][j] - (spreadValue * spreadCount);
				} else {
					spreadArray[i][j] += array[i][j];
				}
			}
		}

		return spreadArray;
	}

	public static boolean isValid(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public static boolean isTopValid(int x, int y, Point p) {
		return x >= 0 && x <= p.x && y >= 0 && y < c;
	}

	public static boolean isbottomValid(int x, int y, Point p) {
		return x >= p.x && x < r && y >= 0 && y < c;
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