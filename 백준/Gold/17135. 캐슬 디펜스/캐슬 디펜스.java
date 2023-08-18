import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] array;
	static int[] findDirectionX = { 0, -1, 0 };
	static int[] findDirectionY = { -1, 0, 1 };
	static int n, m, d, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		d = Integer.parseInt(token.nextToken());

		array = new int[n + 1][m];

		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		setArcher(0, 0, new int[3]);
		System.out.println(answer);
	}
	
	//조합으로 궁수의 위치를 설정
	public static void setArcher(int start, int index, int[] pick) {
		if (index == pick.length) {

			int ArcherRow = n;
			
			int[][] gameMap = copyMap();
			for (int x : pick) {
				gameMap[ArcherRow][x] = 1;
			}
			// 궁수 위치 설정하고 게임 시작
			int gameResult = game(ArcherRow, pick, gameMap);
			answer = Math.max(gameResult, answer);

		} else {
			for (int i = start; i < m; i++) {
				pick[index] = i;
				setArcher(i + 1, index + 1, pick);
			}
		}
	}

	// 배열 복사
	public static int[][] copyMap() {
		int[][] copy = new int[n + 1][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = array[i][j];
			}
		}
		return copy;
	}
	
	public static int game(int ArcherRow, int[] pick, int[][] gameMap) {
		
		int captureCount = 0;
		List<Point> enemyLocation;
		for (int gameCount = 0; gameCount < n; gameCount++) {

			enemyLocation = new ArrayList<>();
			
			// 적을 찾아서 list에 저장
			for (int i = 0; i < 3; i++) {
				enemyLocation.add(findEnemy(new Point(ArcherRow - 1, pick[i]), gameMap));
			}
			for (Point p : enemyLocation) {
				// 위치에서 죽일 수 없는 경우
				if (p == null) {
					continue;
				}
				// 중복되서 같은 적을 동시에 죽일 수 있음
				if (gameMap[p.x][p.y] == 1) {
					captureCount++;
				}
				gameMap[p.x][p.y] = 0;
			}
			// 궁수의 위치를 위로 올린다
			gameMap[ArcherRow - 1] = gameMap[ArcherRow];
			ArcherRow--;

		}

		return captureCount;
	}
	//BFS로 적의 위치를 탐색한다. 가까운 순 & 왼쪽 부터
	public static Point findEnemy(Point p, int[][] gameMap) {

		Queue<Point> q = new LinkedList<Point>();
		q.offer(p);
		int nowDistance = 1;

		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				Point tmp = q.poll();
				if (gameMap[tmp.x][tmp.y] == 1) {
					return tmp;
				}
				for (int j = 0; j < findDirectionX.length; j++) {
					int moveX = tmp.x + findDirectionX[j];
					int moveY = tmp.y + findDirectionY[j];
					if (checkRange(moveX, moveY) && nowDistance < d) {
						q.offer(new Point(moveX, moveY));
					}
				}
			}
			nowDistance++;
		}
		return null;
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
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