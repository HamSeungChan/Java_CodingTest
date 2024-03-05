import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MIN_VALUE;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] array = new int[n][n];
		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		move(0, array);
		System.out.println(answer);
	}

	public static void move(int moveCount, int[][] moveArray) {
		if (moveCount == 5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					answer = Math.max(answer, moveArray[i][j]);
				}
			}

		} else {
			for (int i = 0; i < 4; i++) {
				int[][] newMoveArray = move(moveArray, i);
				move(moveCount + 1, newMoveArray);
			}
		}
	}

	public static int[][] move(int[][] array, int direction) {
		int[][] moveArray = new int[n][n];
		boolean[][] isMerge = new boolean[n][n];

		// left
		if (direction == 0) {
			for (int i = 0; i < n; i++) {
				// 왼쪽으로 몬다
				int index = 0;
				for (int j = 0; j < n; j++) {
					if (array[i][j] == 0) {
						continue;
					}
					if (index >= 1 && moveArray[i][index - 1] == array[i][j] && !isMerge[i][index - 1]) {
						moveArray[i][index - 1] *= 2;
						isMerge[i][index - 1] = true;
						continue;
					}
					moveArray[i][index] = array[i][j];
					index++;
				}
			}
		}

		// right
		else if (direction == 1) {
			for (int i = 0; i < n; i++) {
				// 왼쪽으로 몬다
				int index = n - 1;
				for (int j = n - 1; j >= 0; j--) {
					if (array[i][j] == 0) {
						continue;
					}
					if (index < n - 1 && moveArray[i][index + 1] == array[i][j] && !isMerge[i][index + 1]) {
						moveArray[i][index + 1] *= 2;
						isMerge[i][index + 1] = true;
						continue;
					}
					moveArray[i][index] = array[i][j];
					index--;
				}
			}
		}

		// 위로
		else if (direction == 2) {
			for (int i = 0; i < n; i++) {
				int index = 0;
				for (int j = 0; j < n; j++) {
					if (array[j][i] == 0) {
						continue;
					}
					if (index >= 1 && moveArray[index - 1][i] == array[j][i] && !isMerge[index - 1][i]) {
						moveArray[index - 1][i] *= 2;
						isMerge[index - 1][i] = true;
						continue;
					}
					moveArray[index][i] = array[j][i];
					index++;
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				int index = n - 1;
				for (int j = n - 1; j >= 0; j--) {
					if (array[j][i] == 0) {
						continue;
					}
					if (index < n - 1 && moveArray[index + 1][i] == array[j][i] && !isMerge[index + 1][i]) {
						moveArray[index + 1][i] *= 2;
						isMerge[index + 1][i] = true;
						continue;
					}
					moveArray[index][i] = array[j][i];
					index--;
				}
			}
		}

		return moveArray;
	}
}