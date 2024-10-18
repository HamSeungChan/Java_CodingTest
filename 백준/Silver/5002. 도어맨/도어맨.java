import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int x;
    static int[] array;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split("");
        array = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].equals("W")) {
                array[i] = 0;
                continue;
            }
            array[i] = 1;
        }

        dp = new int[101][2][101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 101; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        System.out.println(recursion(1, array[0], 0, 0));

    }

    public static int recursion(int index, int first, int man, int woman) {

        if (dp[index][first][man][woman] != -1) {
            return dp[index][first][man][woman];
        }

        if (index == array.length) {

            if (array[first] == 0 && Math.abs((woman + 1) - man) <= x) {
                return 1;
            }

            if (array[first] == 1 && Math.abs(woman - (man + 1)) <= x) {
                return 1;
            }

            return 0;
        }

        // 첫번째 사람을 들여보내는 경우

        int max = 0;

        // 여자인 경우
        if (first == 0) {
            if (Math.abs(man - (woman + 1)) <= x) {
                max = Math.max(max, recursion(index + 1, array[index], man, woman + 1) + 1);
            }
        } else {
            if (Math.abs((man + 1) - woman) <= x) {
                max = Math.max(max, recursion(index + 1, array[index], man + 1, woman) + 1);
            }
        }


        // 두번째 사람을 들여보내는 경우
        if (array[index] == 0) {
            if (Math.abs(man - (woman + 1)) <= x) {
                max = Math.max(max, recursion(index + 1, first, man, woman + 1) + 1);

            }
        } else {
            if (Math.abs((man + 1) - woman) <= x) {
                max = Math.max(max, recursion(index + 1, first, man + 1, woman) + 1);
            }
        }

        return dp[index][first][man][woman] = max;
    }
}