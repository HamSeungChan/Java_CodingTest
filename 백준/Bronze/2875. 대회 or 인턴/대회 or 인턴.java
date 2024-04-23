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
		int k = Integer.parseInt(token.nextToken());

		int answer = 0;

		// 남학생의 수
		for (int i = 1; i <= m; i++) {

			// 남학생의 수 * 2 의 여학생이 존재하는지 확인
			if (i * 2 > n) {
				break;
			}

			// 팀을 만들었는데 인턴 수를 제외한 수보다 큰 경우 확인
			if (i * 2 + i > n + m - k) {
				break;
			}

			answer = i;
		}

		System.out.println(answer);
	}
}