import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int l = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());

		int answer = Integer.MAX_VALUE;

		int[][] array = new int[k][2];
		for (int i = 0; i < k; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(token.nextToken());
			array[i][1] = Integer.parseInt(token.nextToken());
		}

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {

				int count = 0;

				int startX = array[i][0];
				int startY = array[j][1];
				
				int endX = startX + l;
				int endY = startY + l;

				for (int x = 0; x < k; x++) {
					if (startX <= array[x][0] && array[x][0] <= endX && startY <= array[x][1] && array[x][1] <= endY) {
						count++;
					}
				}
				answer = Math.min(answer, k - count);

			}
		}
		System.out.println(answer);
	}
}