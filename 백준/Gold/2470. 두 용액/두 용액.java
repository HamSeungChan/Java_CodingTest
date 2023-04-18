
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answerLt = 0;
        int answerRt = 0;
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int lt = 0;
        int rt = n - 1;
        int answer = Integer.MAX_VALUE;
        while (lt < rt) {

            int sum = array[lt] + array[rt];
            int absSum = Math.abs(sum);

            if (answer > absSum) {
                answerLt = array[lt];
                answerRt = array[rt];
                answer = absSum;
            }
            if (sum > 0) {
                rt--;
            } else if (sum < 0) {
                lt++;
            } else {
                System.out.println(array[lt] + " " + array[rt]);
                break;
            }
        }
        System.out.println(answerLt+" "+answerRt);
    }
}
