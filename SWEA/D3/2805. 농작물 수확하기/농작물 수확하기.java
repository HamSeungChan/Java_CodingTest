import java.util.Scanner;

public class Solution {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int t = 1; t<=test_case;t++) {
			int n= sc.nextInt();
			int [][] farm = new int[n][n];
			for(int i=0; i<n;i++) {
				String tmp = sc.next();
				String [] farmInfo = tmp.split("");
				for(int j =0; j<n; j++) {
					farm[i][j] = Integer.parseInt(farmInfo[j]);
				}
			}
			int upIndex = 0;
			int downIndex = n - 1;
			int middle = n/2;
			int answer =0;
			
			for(int i=0; i<= n/2 - 1;i++) {
				int startIndex = middle - i;
				int endIndex = middle + i;
				for(int j = startIndex; j<=endIndex;j++) {
				answer += farm[upIndex][j] + farm[downIndex][j];
				}
				upIndex++;
				downIndex--;
			}
			
			for(int i =0; i< n; i++) {
				answer += farm[n/2][i];
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}
}
