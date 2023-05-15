import java.util.Scanner;

public class Main {
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int [] array;
	static int n;
	static int [] operator;
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		array = new int[n];
		for(int i =0; i< n; i++) {
			array[i] = sc.nextInt();
		}
		operator = new int[4];
		for(int i=0; i< operator.length; i++) {
			operator[i] = sc.nextInt();
		}
		
		new Main().DFS(0, new int[n-1]);
		System.out.println(max);
		System.out.println(min);
	}
	
	
	public void DFS(int value, int [] tmp) {
		if(value == n-1) {
			int sum = 0;
			for(int i =0; i<array.length;i++) {
				if(i==0) {
					sum = array[i];
					continue;
				}
				if(tmp[i-1] ==0) {
					sum += array[i];
				}
				else if(tmp[i-1] ==1){
					sum -= array[i];
				}
				else if(tmp[i-1] ==2) {
					sum *= array[i];
				}
				else {
					sum /= array[i];
				}
			}
			if(sum > max) {
				max = sum;
			}
			
			if(sum < min) {
				min = sum;
			}
		}
		else {
			for(int i=0; i< operator.length;i++) {
				if(operator[i] >0) {
				tmp[value] = i;
				operator[i]--;
				DFS(value+1, tmp);
				operator[i]++;
				}
			}
		}
	}
	
	
}
