import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        find(2, 0);
        find(3, 0);
        find(5, 0);
        find(7, 0);
        System.out.println(builder);
    }

    public static void find(int value, int count) {
        if (count == n - 1) {
            for (int i = 2; i < value; i++) {
                if (value % i == 0) {
                    return;
                }
            }
            builder.append(value).append("\n");
        } else {
            value *= 10;
            for (int i = 1; i < 10; i++) {
                int tmp = value + i;
                boolean flag = true;
                for (int j = 2; j < tmp; j++) {
                    if (tmp % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    find(tmp, count + 1);
                }
            }
        }
    }
}