import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int maxHigh = Integer.MIN_VALUE;
		int maxRight = Integer.MIN_VALUE;

		int[] array = new int[1001];

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");

			int l = Integer.parseInt(token.nextToken());
			int h = Integer.parseInt(token.nextToken());

			maxRight = Math.max(maxRight, l);
			maxHigh = Math.max(maxHigh, h);

			array[l] = h;
		}

		int count = 0;

		for (int i = 1; i <= maxHigh; i++) {

			int startPoint = 0;
			int endPoint = 0;

			// 좌측부터 시작 포인트
			for (int j = 0; j <= maxRight; j++) {
				if (array[j] >= i) {
					startPoint = j;
					break;
				}
			}

			// 우측부터 끝나는 포인트
			for (int j = maxRight; j >= 0; j--) {
				if (array[j] >= i) {
					endPoint = j;
					break;
				}
			}

			count += endPoint - startPoint + 1;
		}
		System.out.println(count);
	}
}