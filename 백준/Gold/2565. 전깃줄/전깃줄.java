import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] array = new int[n][2];
		int[] dp = new int[n];
		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(token.nextToken());
			array[i][1] = Integer.parseInt(token.nextToken());
		}

		Arrays.sort(array, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

//		for (int[] x : array) {
//			System.out.println(x[0] + " " + x[1]);
//		}

		for (int i = 0; i < n; i++) {
			
			dp[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if(array[i][1] > array[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
			
		int max = 0;
		for(int i = 0; i < n; i++){
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(n - max);
		
	}
}