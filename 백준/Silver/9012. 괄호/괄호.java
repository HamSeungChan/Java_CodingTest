import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> answerList = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String answer = "YES";
            char[] ch = s.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char c : ch) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        answer = "NO";
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                answer = "NO";
            }

            answerList.add(answer);
        }
        for(String s : answerList){
            System.out.println(s);
        }
    }
}