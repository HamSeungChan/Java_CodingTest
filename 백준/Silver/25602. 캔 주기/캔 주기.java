import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] canArray;
	static int[][] rang, merry;
	static int n, k, answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());

		rang = new int[k][n];
		merry = new int[k][n];

		canArray = new int[n];
		token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			canArray[i] = Integer.parseInt(token.nextToken());
		}

		for (int i = 0; i < k; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				rang[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				merry[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		permutation(0, new int[k], new int[k]);
		System.out.println(answer);
	}

	public static void permutation(int index, int[] rangPicks, int[] merryPicks) {

		if (index == k) {
			
			// 만족도를 저장하는 변수
			int sum = 0;
			// 고른 캔의 갯수를 저장하는 배열
			int[] pickCount = new int[n];
			for (int i = 0; i < k; i++) {

				int rangPick = rangPicks[i];
				int merryPick = merryPicks[i];

				// 고른 캔을 저장한다.
				pickCount[rangPick]++;
				pickCount[merryPick]++;

				// 선택한 캔에 대한 만족도를 더해간다.
				sum += (rang[i][rangPick] + merry[i][merryPick]);
			}

			// 집사가 가져있는 캔의 갯수와 선택한 캔의 갯수를 비교한다.
			for (int i = 0; i < n; i++) {
				// 0 보다 작다면 불가능한 경우이다.
				if (canArray[i] - pickCount[i] < 0) {
					return;
				}
			}

			answer = Math.max(answer, sum);

		} else {

			for (int i = 0; i < n; i++) {
				rangPicks[index] = i;
				for (int j = 0; j < n; j++) {
					merryPicks[index] = j;
					permutation(index + 1, rangPicks, merryPicks);
				}
			}
		}
	}
}