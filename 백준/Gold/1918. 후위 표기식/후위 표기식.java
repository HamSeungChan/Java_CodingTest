import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        map.put('(', 0);
        map.put(')', 0);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
                // 연산자
            } else {
                switch (c) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)) {
                            sb.append(stack.pop());
                        }
                        stack.add(c);
                        break;
                    case '(':
                        stack.add(c);
                        break;
                    case ')':
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                        break;
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}