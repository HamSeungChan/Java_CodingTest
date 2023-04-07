
import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(x);
            }

            else if (stack.peek()=='(' && x==')') {
                stack.pop();
            }
            else {
                stack.push(x);
            }
        }

      

        return stack.isEmpty();
    }
}