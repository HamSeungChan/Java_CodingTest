import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answerCount = Integer.MAX_VALUE;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        answer = new int[n];

        move(n, 0, new int[n], 0);

        System.out.println(answerCount);
        for (int i = 0; i <= answerCount; i++) {
            System.out.print(answer[i] + " ");
        }
    }


    public static void move(int value, int count, int[] array, int index) {

        if (count >= answerCount) {
            return;
        }

        array[index] = value;

        if (value == 1) {

            if (answerCount > count) {
                answerCount = count;
                for(int i = 0; i <= answerCount; i++){
                    answer[i] = array[i];
                }
            }

        } else {

            if (value % 3 == 0) {
                move(value / 3, count + 1, array, index + 1);
            }

            if (value % 2 == 0) {
                move(value / 2, count + 1, array, index + 1);
            }

            move(value - 1, count + 1, array, index + 1);


        }

    }
}