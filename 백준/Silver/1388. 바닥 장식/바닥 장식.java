import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {

            String s = sc.next();
            char[] c = s.toCharArray();

            for (int j = 0; j < m; j++) {
                if (c[j] == '-') {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }

        int sum = main.checkRow(array,n,m) + main.checkColumn(array,n,m);
        System.out.println(sum);
    }

    public int checkRow(int [][] array, int n, int m){
        int count = 0;
        for(int i = 0; i<n; i++){
            Stack<Integer> stack1 = new Stack<>();
            for(int j=0; j<m; j++){
                if(stack1.isEmpty() || stack1.peek() != array[i][j]){
                    stack1.push(array[i][j]);
                }
            }
            while(!stack1.isEmpty()){
                if(stack1.pop()==1) count++;
            }
        }
        return count;
    }

    public int checkColumn(int [][] array, int n, int m){
        int count = 0;
        for(int i = 0; i<m; i++){
            Stack<Integer> stack2 = new Stack<>();
            for(int j=0; j<n; j++){
                if(stack2.isEmpty() || stack2.peek() != array[j][i]){
                    stack2.push(array[j][i]);
                }
            }
            while(!stack2.isEmpty()){
                if(stack2.pop()==0) count++;
            }
        }
        return count;
    }
}