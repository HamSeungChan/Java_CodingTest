import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();
        int[] count = new int[array.length];
        int index = -1;
        Stack<Point> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {

            if (array[i] == '(') {
                stack.add(new Point(i, array[i]));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    count[i] = 1;
                } else {
                    index = i;
                    break;
                }
            }
        }

        int answer = 0;
        if (!stack.isEmpty()) {
            index = stack.pop().index;
            for (int i = index; i < array.length; i++) {
                answer += count[i];
            }
        } else {
            for (int i = 0; i < index; i++) {
                answer += count[i];
            }
        }

        System.out.println(answer + 1);
    }
}

class Point {
    int index;
    char c;

    public Point(int index, char c) {
        this.index = index;
        this.c = c;
    }
}