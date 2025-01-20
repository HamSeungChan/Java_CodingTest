import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int n, s;
    static int[][] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        s = Integer.parseInt(token.nextToken());

        array = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            array[i][0] = Integer.parseInt(token.nextToken());
            array[i][1] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array, Comparator.comparingInt(o -> o[0]));

        dp = new int[n + 1];
        dp[1] = array[1][1];


        for (int i = 1; i <= n; i++) {

            int beforeIndex = find(array[i][0], i);
            dp[i] = Math.max(dp[i - 1], dp[beforeIndex] + array[i][1]);

        }

        System.out.println(dp[n]);
    }


    // s 보다 작은 것 중 가장 오른쪽 index 를 찾는 함수
    public static int find(int height, int index) {

        int lt = 0;
        int rt = index;
        int findIndex = 0;

        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            if (array[mid][0] <= height - s) {
                lt = mid + 1;
                findIndex = mid;
            } else {
                rt = mid - 1;
            }

        }

        return findIndex;
    }

//    탑다운 불가능 -> dp 배열이 너무 큼
//    public static int recursion(int index, int lastIndex) {
//
//        if (dp[index][lastIndex] != -1) {
//            return dp[index][lastIndex];
//        }
//
//
//        if (index == n) {
//            return 0;
//        }
//
//        int max = 0;
//
//        // 선택한다.
//        if (index == 0 || array[index][0] - array[lastIndex][0] >= s) {
//            max = Math.max(max, recursion(index + 1, index) + array[index][1]);
//        }
//
//        // 선택하지 않는다.
//        max = Math.max(max, recursion(index + 1, lastIndex));
//
//        return dp[index][lastIndex] = max;
//    }

}