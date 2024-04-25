import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int[] array = new int[5];

		for (int i = 0; i < 5; i++) {
			array[i] = Integer.parseInt(token.nextToken());

		}

		for (int i = 1; i <= 100000000; i++) {

			int check = 0;
			for (int j = 0; j < 5; j++) {
				if (i % array[j] == 0) {
					check++;
				}
			}

			if (check >= 3) {
				System.out.println(i);
				break;
			}
		}
	}
}