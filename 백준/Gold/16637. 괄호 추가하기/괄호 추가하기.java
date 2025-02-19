import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, answer = Integer.MIN_VALUE;
    static String[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = br.readLine().split("");
        recursion(2, Integer.parseInt(array[0]));
        System.out.println(answer);
    }

    public static void recursion(int index, int value) {

        if (index > n) {
            answer = Math.max(answer, value);
            return;
        }

        // 묶는다.
        if (index != n - 1) {
            recursion(index + 4,
                    result(
                            value,
                            array[index - 1],
                            result(Integer.parseInt(array[index]), array[index + 1], Integer.parseInt(array[index + 2]))
                    )
            );
        }


        // 안묶는다.
        recursion(index + 2, result(value, array[index - 1], Integer.parseInt(array[index])));
    }

    public static int result(int a, String b, int c) {

        int tmp = 0;

        switch (b) {
            case "+":
                tmp = a + c;
                break;
            case "-":
                tmp = a - c;
                break;
            default:
                tmp = a * c;
        }

        return tmp;
    }
}