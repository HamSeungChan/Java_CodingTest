import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int[] MOVE_X = { 0, 1, 0, -1 };
	static int[] MOVE_Y = { 1, 0, -1, 0 };
	static char[] tank = { '>', 'v', '<', '^' };
	static int h, w;
	static char [][] array;
	static int x, y, direction;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			sb.append('#').append(t).append(" ");
			String[] tmp = br.readLine().split(" ");

			h = Integer.parseInt(tmp[0]);
			w = Integer.parseInt(tmp[1]);

			array = new char[h][w];
			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				for (int j = 0; j < w; j++) {
					char c = s.charAt(j);
					if (c == '<' || c == '>' || c == '^' || c == 'v') {
						x = i;
						y = j;
						if (c == '>') {
							direction = 0;
						} else if (c == 'v') {
							direction = 1;
						} else if (c == '<') {
							direction = 2;
						} else {
							direction = 3;
						}
					}
					array[i][j] = c;
				}
			}

			int n = Integer.parseInt(br.readLine());
			String order = br.readLine();
			for (int i = 0; i < n; i++) {
				game(order.charAt(i));
			}

			for(int i = 0; i < h; i++) {
				sb.append(array[i]).append("\n");
			}
			

//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(array[i][j]);
//				}
//				System.out.println();
//			}

		}
		System.out.print(sb);
	}

	public static void game(char c) {
		switch (c) {
		case 'U':
			direction = 3;
			move();
			break;
		case 'D':
			direction = 1;
			move();
			break;
		case 'L':
			direction = 2;
			move();
			break;
		case 'R':
			direction = 0;
			move();
			break;
		default:
			shot();
		}
	}

	public static void move() {
		
		int moveX = x + MOVE_X[direction];
		int moveY = y + MOVE_Y[direction];
		array[x][y] = tank[direction];

		if (moveX >= 0 && moveX < h && moveY >= 0 && moveY < w && array[moveX][moveY]=='.') {
			array[x][y] = '.';
			x = moveX;
			y = moveY;
			array[x][y] = tank[direction];
		}
	}

	public static void shot() {

		int shotX = x;
		int shotY = y;

		while (true) {

			shotX += MOVE_X[direction];
			shotY += MOVE_Y[direction];

			if (shotX >= 0 && shotX < h && shotY >= 0 && shotY < w) {

				if (array[shotX][shotY] == '*') {
					array[shotX][shotY] = '.';
					break;
				} else if (array[shotX][shotY] == '#') {
					break;
				}
			} else {
				break;
			}
		}

	}

}