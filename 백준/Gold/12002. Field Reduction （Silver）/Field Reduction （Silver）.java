import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Point[] points;
	static int n, answer = Integer.MAX_VALUE;
	static List<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		points = new Point[n];

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			points[i] = new Point(x, y);
		}

		getEndPoint();
		recursive(0, 0, new HashSet<>());
		System.out.println(answer);
	}

	public static void recursive(int index, int pickCount, Set<Point> pickInfo) {

		if (pickCount == 3) {

			int minX = Integer.MAX_VALUE;
			int minY = Integer.MAX_VALUE;
			int maxX = Integer.MIN_VALUE;
			int maxY = Integer.MIN_VALUE;

			for (int i = 0; i < points.length; i++) {
				Point tmp = points[i];
				if (!pickInfo.contains(tmp)) {
					minX = Math.min(minX, tmp.x);
					maxX = Math.max(maxX, tmp.x);
					minY = Math.min(minY, tmp.y);
					maxY = Math.max(maxY, tmp.y);
				}
			}
			answer = Math.min(answer, (maxX - minX) * (maxY - minY));
			return;
		}

		if (index == list.size()) {
			return;
		}

		// 선택하지 않은 경우
		recursive(index + 1, pickCount, pickInfo);

		// 선택한 경우
		Point tmp = list.get(index);
		pickInfo.add(tmp);
		recursive(index + 1, pickCount + 1, pickInfo);
		pickInfo.remove(tmp);
	}

	public static void getEndPoint() {

		Arrays.sort(points, (a, b) -> a.x - b.x);
		for (int i = 0; i < 3; i++) {
			Point tmp = points[i];
			if (!list.contains(tmp)) {
				list.add(new Point(tmp.x, tmp.y));
			}

		}

		for (int i = 0; i < 3; i++) {
			Point tmp = points[n - 1 - i];
			if (!list.contains(tmp)) {
				list.add(new Point(tmp.x, tmp.y));
			}
		}

		Arrays.sort(points, (a, b) -> a.y - b.y);
		for (int i = 0; i < 3; i++) {
			Point tmp = points[i];
			if (!list.contains(tmp)) {
				list.add(new Point(tmp.x, tmp.y));
			}
		}

		for (int i = 0; i < 3; i++) {
			Point tmp = points[n - 1 - i];
			if (!list.contains(tmp)) {
				list.add(new Point(tmp.x, tmp.y));
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point point = (Point)o;
		return x == point.x && y == point.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}