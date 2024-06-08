import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(array);
        permutation(0, 0, new boolean[n], 0);
        System.out.println(answer);
    }

    public static void permutation(int index, int pickCount, boolean[] pickArray, int height) {

        if (pickCount == 2) {

            int lt = 0;
            int rt = n - 1;

            while (pickArray[lt]) {
                lt++;
            }

            while (pickArray[rt]) {
                rt--;
            }

            while (lt < rt) {

                int sum = array[lt] + array[rt];
                answer = Math.min(answer, Math.abs(sum - height));

                if (height > sum) {
                    do {
                        lt++;
                    } while (pickArray[lt]);
                } else if (height < sum) {
                    do {
                        rt--;
                    } while (pickArray[rt]);
                } else {
                    break;
                }
            }
            return;
        }

        if (index == n) {
            return;
        }

        pickArray[index] = true;
        permutation(index + 1, pickCount + 1, pickArray, height + array[index]);

        pickArray[index] = false;
        permutation(index + 1, pickCount, pickArray, height);
    }

}