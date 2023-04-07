import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                stack.pop();
                continue;
            }
            stack.push(x);
 
       }

        while(!stack.empty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}