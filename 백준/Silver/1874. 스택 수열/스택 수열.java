import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {

            int tmp = sc.nextInt();
            if (!stack.isEmpty()) {
                if (stack.peek() > tmp) {
                    list.clear();
                    list.add("NO");
                    break;
                }

                if (stack.peek() == tmp) {
                    stack.pop();
                    list.add("-");
                    continue;
                }
            }

            while (tmp >= number) {
                stack.push(number++);
                list.add("+");
            }
            stack.pop();
            list.add("-");
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}