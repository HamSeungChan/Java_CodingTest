import java.util.Scanner;

public class Solution {
	public static void main(String [] args) {
		Scanner sc= new Scanner(System.in);
		int test = 10;
		for(int t= 1; t<=test;t++) {
			int answer =0;
			int test_case = sc.nextInt();
			int [] column = new int[100];
			int [] row = new int[100];
			int diagonal = 0;
			int reverseDiagonal = 0;
			
			for(int i=0; i< 100; i++) {
				for(int j=0; j< 100; j++) {
					int tmp = sc.nextInt();
					column[i] += tmp;
					row[j] += tmp;
					if(i == j) {
						diagonal += tmp;
					}
					if(i+j == 99) {
						reverseDiagonal += tmp;
					}
				}
			}
			
			for(int i=0; i< 100; i++) {
				answer =Math.max(answer,Math.max(column[i], row[i]));
			}
			System.out.println("#"+t+" "+Math.max(answer, Math.max(diagonal, reverseDiagonal)));
		}
	}
}
