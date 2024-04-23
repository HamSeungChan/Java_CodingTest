import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int answer = 0;

		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				for (int k = 1; k < 100; k++) {

					if (i + j + k != n)
						continue;

					if (k < j + 2)
						continue;

					if (i % 2 == 1)
						continue;
					
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}