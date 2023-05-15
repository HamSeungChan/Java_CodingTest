import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 10;
        for (int t = 1; t <= testCase; t++) {
            int answer = 0;
            int move = Integer.parseInt(br.readLine());
            int[] array = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < move; i++) {
                Arrays.sort(array);

//                if (array[0] == array[array.length - 1]) {
//                    answer = 0;
//                    break;
//                }
//
//                if (array[0] - 1 == array[array.length - 1]) {
//                    answer = 1;
//                    break;
//                }
                array[0] += 1;
                array[array.length - 1] -= 1;
            }

            Arrays.sort(array);
            System.out.println("#"+t+" "+(array[array.length-1]-array[0]));

        }
    }
}
