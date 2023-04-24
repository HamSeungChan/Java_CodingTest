import java.util.Stack;
class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(x);
            } else {
                char peek = stack.peek();
                if (peek != x) {
                    stack.push(x);
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) return 1;
        return 0;
    }
}