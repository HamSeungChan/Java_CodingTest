import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        // 휴게소의 개수
        n = Integer.parseInt(token.nextToken());
        // 더 지으려는 휴게소의 개수
        int m = Integer.parseInt(token.nextToken());
        // 고속도로의 길이
        int l = Integer.parseInt(token.nextToken());

        array = new int[n + 2];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        array[0] = 0;
        array[n + 1] = l;

        Arrays.sort(array);

        int lt = 1;
        int rt = l - 1;
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int result = solution(mid, m);

            if (result >= 0) {
                answer = mid;
                rt = mid - 1;
                continue;
            }

            lt = mid + 1;
        }

        System.out.println(answer);
    }

    public static int solution(int value, int volume) {

        int before = array[0];
        for (int i = 1; i < n + 2; i++) {
            while (array[i] - before > value) {
                volume--;
                if (volume == -1) {
                    return -1;
                }
                before = before + value;
            }

            before = array[i];
        }

        return volume;
    }
}