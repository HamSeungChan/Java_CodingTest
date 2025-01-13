import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 마실 수 있는 포도주 중 가장 맛있는 포도주와 맛없는 포도주를 반복
 * */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[] array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }


        Arrays.sort(array);


        // 가장 맛있는 포도주는 마신 상태
        int lt = -1;
        int rt = n - 2;
        int drinkCount = 1;
        long answer = array[n - 1];
        boolean flag = true;

        while (drinkCount < k) {

            // 맛있는 포도주를 마신다.
            if (!flag) {
                answer += array[rt] - array[lt];
                rt--;
                flag = true;
            }
            // 맛없는 포도주를 마신다.
            else {
                lt++;
                flag = false;
            }

            drinkCount++;
        }

        System.out.println(answer);
    }


}