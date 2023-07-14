import java.util.Scanner;

public class Main {

	static int[] MOVE_X = { 0,1,1,1,0,-1,-1,-1 };
	static int[] MOVE_Y = { 1,1,0,-1,-1,-1,0,1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int answer = 0;
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w == 0 & h == 0)
				break;
			int[][] array = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					array[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (array[i][j] == 1) {
						answer++;
						DFS(array, new Point(i, j));
					}
				}
			}
			System.out.println(answer);
		}
	}

	public static void DFS(int[][] array, Point p) {

		array[p.x][p.y] = 0;

		for (int i = 0; i < MOVE_X.length; i++) {
			int mX = p.x + MOVE_X[i];
			int mY = p.y + MOVE_Y[i];
			if (mX >= 0 && mX < array.length && mY >= 0 && mY < array[0].length && array[mX][mY] == 1) {
				DFS(array, new Point(mX, mY));
			}
		}

	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}