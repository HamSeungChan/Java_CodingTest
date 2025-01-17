import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long a, b, c;
    static int[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        a = Long.parseLong(token.nextToken());
        b = Long.parseLong(token.nextToken());
        c = Long.parseLong(token.nextToken());

//        check = new int[b + 1];

        System.out.println(recursion(b) % c);
    }

    public static long recursion(long now) {

//        if (check[now] != 0) {
//            return check[now];
//        }

        if (now == 1) {
            return a % c;
        }

        long value = recursion(now / 2);

        if (now % 2 == 0) {
            return value * value % c;
        } else {
            return (value * value % c) * a % c;
        }
    }
}