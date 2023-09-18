import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < array.length; i++) {

            if (array[i].equals(")")) {

                if (stack.isEmpty()) {
                    break;
                }

                if (stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("2");
                } else {
                    int sum = 0;
                    while (!stack.peek().equals("(")) {

                        String value = stack.pop();
                        if (value.equals("[")) {
                            stack.clear();
                            flag = true;
                            break;
                        }

                        if (stack.isEmpty()) {
                            flag = true;
                            break;
                        }

                        sum += Integer.parseInt(value);
                    }
                    if (flag) {
                        break;
                    }
                    stack.pop();
                    stack.push(String.valueOf(sum * 2));
                }
            } else if (array[i].equals("]")) {

                if (stack.isEmpty()) {
                    break;
                }

                if (stack.peek().equals("[")) {
                    stack.pop();
                    stack.push("3");
                } else {
                    int sum = 0;
                    while (!stack.peek().equals("[")) {
                        String value = stack.pop();
                        if (value.equals("(")) {
                            stack.clear();
                            flag = true;
                            break;
                        }
                        
                        if (stack.isEmpty()) {
                            flag = true;
                            break;
                        }

                        sum += Integer.parseInt(value);
                    }
                    if (flag) {
                        break;
                    }
                    stack.pop();
                    stack.push(String.valueOf(sum * 3));
                }
            } else {
                stack.push(array[i]);
            }
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            int sum = 0;
            while (!stack.isEmpty()) {
                String value = stack.pop();
                if (value.equals("(") || value.equals("[")) {
                    sum = 0;
                    break;
                }
                sum += Integer.parseInt(value);
            }
            System.out.println(sum);
        }

    }

}