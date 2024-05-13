import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, answer = Integer.MAX_VALUE;
	static int[] cost;
	static List<List<DiscountInfo>> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 물약의 종류
		n = Integer.parseInt(br.readLine());

		// 물약의 가격
		cost = new int[n + 1];
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(token.nextToken());
		}

		// 할일 정보를 저장하는 이중 리스트
		list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {

			List<DiscountInfo> discountInfos = list.get(i);
			int tmp = Integer.parseInt(br.readLine());

			for (int j = 0; j < tmp; j++) {
				token = new StringTokenizer(br.readLine(), " ");
				discountInfos.add(
					new DiscountInfo(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
			}
		}

		permutation(0, new int[n], new boolean[n + 1]);
		System.out.println(answer);
	}

	public static void permutation(int index, int[] pick, boolean[] check) {

		if (index == n) {
			// for (int i : pick) {
			// 	System.out.print(i + " ");
			// }
			// System.out.println();

			// cost 정보 복사
			int[] copyCost = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				copyCost[i] = cost[i];
			}

			int sum = 0;
			for (int i = 0; i < pick.length; i++) {

				// 순서 대로 가격 더해 준다.
				int tmp = pick[i];
				sum += copyCost[tmp];

				// 할인
				List<DiscountInfo> discountInfos = list.get(tmp);
				for (DiscountInfo discountInfo : discountInfos) {
					copyCost[discountInfo.index] -= discountInfo.discountAmount;
					if (copyCost[discountInfo.index] < 1) {
						copyCost[discountInfo.index] = 1;
					}
				}
			}
			answer = Math.min(answer, sum);
		}

		for (int i = 1; i <= n; i++) {
			if (!check[i]) {
				pick[index] = i;
				check[i] = true;
				permutation(index + 1, pick, check);
				check[i] = false;
			}
		}

	}

}

class DiscountInfo {

	int index;
	int discountAmount;

	public DiscountInfo(int index, int discountAmount) {
		this.index = index;
		this.discountAmount = discountAmount;
	}
}