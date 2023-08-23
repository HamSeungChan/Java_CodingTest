import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, totalSum = 0;
	static int[] people;
	static boolean[][] array;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		people = new int[n + 1];
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			people[i] = Integer.parseInt(token.nextToken());
			totalSum += people[i];
		}

		array = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int linkSize = Integer.parseInt(token.nextToken());
			for (int j = 0; j < linkSize; j++) {
				array[i][Integer.parseInt(token.nextToken())] = true;
			}
		}

		powerSet(0, 1, new boolean[n + 1], 0);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	public static void powerSet(int pickCount, int index, boolean[] pick, int sum) {

		if (index == n + 1) {

			if (pickCount == 0 || pickCount == n) {
				return;
			}

			int[] aLocation = new int[pickCount];
			int aIndex = 0;
			int[] bLocation = new int[n - pickCount];
			int bIndex = 0;

			for (int i = 1; i <= n; i++) {
				if (pick[i]) {
					aLocation[aIndex++] = i;
				} else {
					bLocation[bIndex++] = i;
				}
			}

			if (isConnect(aLocation) && isConnect(bLocation)) {
				answer = Math.min(answer, Math.abs((totalSum - sum) - sum));
			}

		} else {
			pick[index] = true;
			powerSet(pickCount + 1, index + 1, pick, sum + people[index]);
			pick[index] = false;
			powerSet(pickCount, index + 1, pick, sum);
		}

	}

	public static boolean isConnect(int[] location) {
		boolean[] check = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(location[0]);
		while (!q.isEmpty()) {
			int tmp = q.poll();
			check[tmp] = true;
			for (int x : location) {
				if (array[tmp][x] == true && check[x] == false) {

					q.offer(x);
				}
			}
		}
		for (int i = 0; i < location.length; i++) {
			if (check[location[i]] == false) {
				return false;
			}
		}
		return true;
	}

}