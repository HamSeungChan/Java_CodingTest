import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(token.nextToken());
		m = Integer.valueOf(token.nextToken());
		permutaion(new int[m], new int[n], 0);
	}

	public static void permutaion(int[] array, int[] check, int count) {
		if (count == m) {
			for (int x : array) {
				System.out.print((x+1) + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < n; i++) {
				if (check[i] != 1) {
					array[count] = i;
					check[i] = 1;
					permutaion(array, check, count + 1);
					check[i] = 0;
				}
			}
		}
	}

}