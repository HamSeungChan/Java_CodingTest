import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

//	static int[] array;
//
//	public static int find(int n) {
//		if (array[n] == n) {
//			return n;
//		}
//
//		return array[n] = find(array[n]);
//	}
//
//	public static boolean union(int a, int b) {
//		int aFind = find(a);
//		int bFind = find(b);
//
//		if (aFind == bFind) {
//			return false;
//		}
//
//		array[bFind] = aFind;
//		return true;
//	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] array = new int[n + 1][n + 1];
		StringTokenizer token;
		for (int i = 1; i <= n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		int[] minIndex = new int[n + 1];
		boolean[] check = new boolean[n + 1];
		Arrays.fill(minIndex, Integer.MAX_VALUE);
		minIndex[1] = 0;

		long sum = 0;

		for (int i = 1; i <= n; i++) {

			int index = -1;
			int minValue = Integer.MAX_VALUE;

			for (int j = 1; j <= n; j++) {
				if (!check[j] && minIndex[j] < minValue) {
					index = j;
					minValue = minIndex[j];
				}
			}

			check[index] = true;
			sum += minValue;

			for (int j = 1; j <= n; j++) {
				if (!check[j] && array[index][j] > 0 && minIndex[j] > array[index][j]) {
					minIndex[j] = array[index][j];
				}
			}
		}

		System.out.println(sum);

	}
}