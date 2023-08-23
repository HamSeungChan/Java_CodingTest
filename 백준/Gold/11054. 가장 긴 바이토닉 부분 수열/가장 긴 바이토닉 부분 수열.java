import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] array;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		array = new int[n];
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}

		int[] dpLR = new int[n];
		for (int i = 0; i < n; i++) {
			dpLR[i] = 1;
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j]) {
					dpLR[i] = Math.max(dpLR[i], dpLR[j] + 1);
				}
			}
		}

		int[] dpRL = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			dpRL[i] = 1;
			for (int j = n - 1; j > i; j--) {
				if (array[i] > array[j]) {
					dpRL[i] = Math.max(dpRL[i], dpRL[j] + 1);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dpLR[i] + dpRL[i]);
		}

		System.out.println(max - 1);

	}

}