import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] array;

	public static int find(int n) {
		if (array[n] == n) {
			return n;
		}
		return array[n] = find(array[n]);
	}

	public static boolean union(int a, int b) {
		int aFind = find(a);
		int bFind = find(b);

		if (aFind == bFind) {
			return false;
		}

		array[bFind] = aFind;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		array = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			array[i] = i;
		}

		StringTokenizer token;
		for (int i = 1; i <= n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				if (Integer.parseInt(token.nextToken()) == 1) {
					union(i, j);
				}
			}
		}

		StringBuilder sb = new StringBuilder("YES");
		token = new StringTokenizer(br.readLine());
		int[] travel = new int[m];
		for (int i = 0; i < m; i++) {
			travel[i] = Integer.parseInt(token.nextToken());
		}

		for (int i = 0; i < m; i++) {
			if (find(travel[0]) != find(travel[i])) {
				sb = new StringBuilder("NO");
			}
		}

		System.out.println(sb);

	}
}