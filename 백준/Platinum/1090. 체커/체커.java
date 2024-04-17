import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] array = new int[n][2];
		Set<Integer> xLocation = new HashSet<>();
		Set<Integer> yLocation = new HashSet<>();

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(token.nextToken());
			array[i][1] = Integer.parseInt(token.nextToken());

			xLocation.add(array[i][0]);
			yLocation.add(array[i][1]);
		}

		int[] answer = new int[n + 1];
		Arrays.fill(answer, Integer.MAX_VALUE);

		List<Integer> xList = xLocation.stream().collect(Collectors.toList());
		List<Integer> yList = yLocation.stream().collect(Collectors.toList());

		for (Integer xValue : xList) {
			for (Integer yValue : yList) {

				int x = xValue;
				int y = yValue;

				// 각 점과의 거리를 구한다.
				int[] tmp = new int[n];
				for (int k = 0; k < n; k++) {
					tmp[k] = Math.abs(array[k][0] - x) + Math.abs(array[k][1] - y);
				}
				// 각 점과의 거리를 정렬해서 1개 ~ n개를 선택했을 때 최솟값을 구한다.
				Arrays.sort(tmp);
				int sum = 0;
				for (int k = 0; k < n; k++) {
					sum += tmp[k];
					answer[k + 1] = Math.min(sum, answer[k + 1]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}
}