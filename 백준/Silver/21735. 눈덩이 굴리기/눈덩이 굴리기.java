import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, answer;
    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        array = new int[n + 1];

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        recursion(0, 1, 0);
        System.out.println(answer);
    }

    public static void recursion(int index, int size, int time) {


        if (time == m) {
            answer = Math.max(answer, size);
            return;
        }


        // +1 칸으로 굴린다.
        if (index + 1 <= n) {
            recursion(index + 1, size + array[index + 1], time + 1);
        }

        // +2 칸으로 던진다.
        if (index + 2 <= n) {
            recursion(index + 2, size / 2 + array[index + 2], time + 1);
        }

        // 아무것도 안하고 시간만 흐른다.
        recursion(index, size, time + 1);
    }
}