import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int s;
    static int[] array;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        s = Integer.parseInt(token.nextToken());
        array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        powerSet(0, new int[n]);
        System.out.println(answer);
    }

    public static void powerSet(int index, int[] check) {
        if (index == n) {
            int zeroCount = 0;
            int sum = 0;
            for (int i = 0; i < check.length; i++) {
                if (check[i] == 0) {
                    zeroCount++;
                }
                if (check[i] == 1) {
                    sum += array[i];
                }
            }
            if (zeroCount != check.length && sum == s) {
                answer++;
            }

        } else {
            check[index] = 1;
            powerSet(index + 1, check);
            check[index] = 0;
            powerSet(index + 1, check);
        }
    }
}