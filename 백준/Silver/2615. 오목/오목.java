import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int[] MOVEX = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static final int[] MOVEY = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int answer = 0;
	static Point answerPoint;
	static int answerDirect;

	static int[][] graph;
	static int[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		graph = new int[19][19];
		check = new int[19][19];
		for (int i = 0; i < 19; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 19; j++) {
				graph[i][j] = Integer.valueOf(s[j]);
			}
		}
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (graph[i][j] != 0) {
					for (int t = 0; t < MOVEX.length; t++) {
						int moveX = i + MOVEX[t];
						int moveY = j + MOVEY[t];
						if (moveX >= 0 && moveX < 19 && moveY >= 0 && moveY < 19
								&& graph[moveX][moveY] == graph[i][j]) {
							DFS(graph[i][j], new Point(i, j), 1, t);
						}
					}
				}
			}
		}
		System.out.println(answer);
		if (answer != 0) {

			int answerX;
			int answerY;
//			System.out.println(answerPoint.x);
//			System.out.println(answerPoint.y);
//			System.out.println(answerPoint.x - MOVEX[answerDirect] * 4);
//			System.out.println(answerPoint.y - MOVEY[answerDirect] * 4);
			if (answerPoint.y > answerPoint.y - MOVEY[answerDirect] * 4) {
				answerX = answerPoint.x - MOVEX[answerDirect] * 4;
				answerY = answerPoint.y - MOVEY[answerDirect] * 4;
			} else if (answerPoint.y == answerPoint.y - MOVEY[answerDirect] * 4) {
				answerX = Math.min(answerPoint.x, answerPoint.x - MOVEX[answerDirect] * 4);
				answerY = answerPoint.y;
			} else {
				answerX = answerPoint.x;
				answerY = answerPoint.y;
			}

			System.out.print((answerX + 1) + " " + (answerY + 1));
		}
	}

	public static void DFS(int value, Point p, int count, int direct) {
		if (count == 5) {
			int moveX = p.x + MOVEX[direct];
			int moveY = p.y + MOVEY[direct];
			if (moveX < 0 || moveX >= 19 || moveY < 0 || moveY >= 19 || graph[moveX][moveY] != value) {

				int backX = p.x - MOVEX[direct] * 5;
				int backY = p.y - MOVEY[direct] * 5;
				if (backX < 0 || backX >= 19 || backY < 0 || backY >= 19 || graph[backX][backY] != value) {

					answer = value;
					answerPoint = p;
					answerDirect = direct;
				}
			}
		}

		else {

			int moveX = p.x + MOVEX[direct];
			int moveY = p.y + MOVEY[direct];
			if (moveX >= 0 && moveX < 19 && moveY >= 0 && moveY < 19 && graph[moveX][moveY] == value) {
				DFS(value, new Point(moveX, moveY), count + 1, direct);

			}
		}
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