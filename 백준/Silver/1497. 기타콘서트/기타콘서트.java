import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소한의 기타로 최대한 많은 곡을 연주하는게 포인트
// 우선 다 안고른다에서 -> 고른다로 이동하면서 기타 선택을 최소 부터 시작
public class Main {

	static int n, m, answer = -1, maxPlay = Integer.MIN_VALUE, minPickCount = Integer.MAX_VALUE;
	static boolean[][] array;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());

		array = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			char[] cArray = tmp[1].toCharArray();
			for (int j = 0; j < m; j++) {
				if (cArray[j] == 'Y') {
					array[i][j] = true;
					continue;
				}
				array[i][j] = false;
			}
		}
		subset(0, 0, new boolean[n]);
		System.out.println(answer);
	}

	public static void subset(int index, int pickCount, boolean[] pick) {

		if (index == n) {

			boolean[] canPlay = new boolean[m];
			for (int i = 0; i < pick.length; i++) {
				if (pick[i]) {
					for (int j = 0; j < m; j++) {
						canPlay[j] = canPlay[j] | array[i][j];
					}
				}
			}

			int canPlayCount = 0;
			for (boolean b : canPlay) {
				if (b) {
					canPlayCount++;
				}
			}

			// 최소한의 기타만 선택하면서 시작함으로 canPlayCount > maxPlay 로 if문 조건
			if (canPlayCount > maxPlay && canPlayCount > 0) {
				maxPlay = canPlayCount;
				minPickCount = pickCount;
				answer = minPickCount;
			}
			// canPlayCount가 같을 때는 pickCount를 최소화
			else if (canPlayCount == maxPlay && canPlayCount > 0) {
				minPickCount = Math.min(pickCount, minPickCount);
				answer = minPickCount;
			}
			return;
		}

		// 기타를 고르지 않은 경우
		pick[index] = false;
		subset(index + 1, pickCount, pick);
		// 기타를 고른 경우
		pick[index] = true;
		subset(index + 1, pickCount + 1, pick);
	}
}