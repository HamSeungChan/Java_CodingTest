import java.util.Scanner;

public class Solution {
	
	static int DIVEDE = 3;
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int t = 1 ;t<= testCase ; t++) {
			int [][] array = new int [9][9];
			for(int i=0; i<9;i++) {
				for(int j=0;j<9;j++) {
					array[i][j] = sc.nextInt();
				}
			}
			System.out.println("#"+t+" "+check(array));
		}
	}
	
	
	static int check(int [][] array) {
		
		for(int i =0; i< 9 ; i++)
		if(checkColumn(i,array) == false) {
			return 0;
		}
		
		for(int i =0; i< 9 ; i++) {
		if(checkRow(i,array) == false) {
			return 0;
			}
		}
		
		for(int i=0; i<9;i++) {
			for(int j=0;j<9;j++) {
				if(checkSquare(i,j,array) == false) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	static boolean checkSquare(int x, int y, int [][] array) {
		
		int divideX = x / DIVEDE * 3;
		int divideY = y / DIVEDE * 3;
		
		for(int i = divideX ; i< divideX+3; i++) {
			for(int j = divideY ; j< divideY+3; j++) {
				if(array[i][j] == array[x][y] && x!= i && y!=j) {
					return false;
				}
			}
		}
		return true;
	}
	
	static boolean checkColumn(int x, int [][] array) {
		int checkArray[] = new int[10];
		for(int i=0; i<9 ; i++) {
			if(checkArray[array[x][i]] != 0) {
				return false;
			}
			checkArray[array[x][i]] = 1;
		}
		
		return true;
	}
	
	static boolean checkRow(int x, int [][] array) {
		int checkArray[] = new int[10];
		for(int i=0; i<9 ; i++) {
			if(checkArray[array[i][x]] != 0) {
				return false;
			}
			checkArray[array[i][x]] = 1;
		}
		return true;
	}
}
