import java.util.Scanner;

public class Main {
	
	static int [][] graph;
	static int n;
	static int sum;
	static int answer = Integer.MAX_VALUE;

	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		graph = new int[n][n];
		for(int i=0; i<n;i++) {
			for(int j =0; j<n;j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		
		new Main().DFS(0,0,new int[n]);
		System.out.println(answer);
	}
	
	static void findScore(int [] team, int value, int [] comb, int [] check) {
		if(value == comb.length) {
			int one = comb[0];
			int two = comb[1];
			sum += graph[one][two];
		}
		else {
			for(int i=0; i< team.length;i++) {
				if(check[i] == 0) {
					comb[value] = team[i];
					check[i] = 1;
					findScore(team,value+1,comb,check);
					check[i] = 0;
				}
			}
		}
	}
	
	
	public void DFS(int start, int value, int [] checkArray) {
		if(value == n/2) {
			int [] team1 = new int[n/2];
			int [] team2 = new int[n/2];
			int indexTeam1 = 0;
			int indexTeam2 = 0;
			for(int i=0; i< checkArray.length;i++) {
				if(checkArray[i] ==1) {
					team1[indexTeam1++] = i;
				}
				else {
					team2[indexTeam2++] = i;
				}
			}
			
			sum = 0;
			findScore(team1,0, new int[2],new int[n/2]);
			int sum1 = sum;

			
			sum = 0;
			findScore(team2,0, new int[2],new int[n/2]);
			int sum2 = sum;

			
			
			if(Math.abs(sum1-sum2)<answer) {
				answer = Math.abs(sum1-sum2);
			}
		}
		else {
			for(int i = start ; i< checkArray.length;i++) {
				checkArray[i] = 1;
				DFS(i+1,value+1,checkArray);
				checkArray[i] = 0;
			}
		}
	}

}
