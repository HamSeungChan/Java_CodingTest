import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] array = new int[10][10];
	static int answer = Integer.MAX_VALUE;
	static List<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		for (int i = 0; i < 10; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				int n = Integer.parseInt(token.nextToken());
				array[i][j] = n;
				if (n == 1) {
					list.add(new Point(i, j));
				}
			}
		}
		int[] paper = new int[6];
		for (int i = 1; i < paper.length; i++) {
			paper[i] = 5;
		}
		recursion(0, paper, new boolean[10][10], 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	public static void recursion(int index, int[] paper, boolean[][] map, int count) {

		if (count > answer) {
			return;
		}

		if (index == list.size()) {
			answer = count;
			return;
		}

		Point tmp = list.get(index);
		for (int i = 5; i >= 1; i--) {
			// 사용하려는 종이가 모두 사용되었을 때
			if (paper[i] == 0) {
				continue;
			}

			// 전에 이미 종이를 붙였을 때
			if (map[tmp.x][tmp.y]) {
				recursion(index + 1, paper, map, count);
				return;
			}

			// 붙이는데 문제가 없는 경우 (범위,이미 붙였는지 확인, 붙일 수 있는 지)
			if (canAttach(i, tmp, map)) {
				paperControl(tmp, i, map);
				paper[i]--;
				recursion(index + 1, paper, map, count + 1);
				paperControl(tmp, i, map);
				paper[i]++;
			}
		}
	}

	public static boolean canAttach(int length, Point tmp, boolean[][] map) {

		// 범위를 벗어난 경우
		if (tmp.x + length > 10 || tmp.y + length > 10) {
			return false;
		}

		// 이미 종이를 붙인 경우 && 0 이 있는 경우
		for (int i = tmp.x; i < tmp.x + length; i++) {
			for (int j = tmp.y; j < tmp.y + length; j++) {
				if (map[i][j] || array[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void paperControl(Point tmp, int length, boolean[][] map) {
		for (int i = tmp.x; i < tmp.x + length; i++) {
			for (int j = tmp.y; j < tmp.y + length; j++) {
				map[i][j] = !map[i][j];
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