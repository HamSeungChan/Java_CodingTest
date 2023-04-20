import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private final static int RGB_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] allHouse = new int[n][RGB_COUNT];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < RGB_COUNT; j++) {
                allHouse[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + allHouse[i-1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + allHouse[i-1][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + allHouse[i-1][2];
        }
        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}


//package baekjoon.b1149;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    private static final int RGB = 3;
//    static int[][] houseRGB;
//    static int house;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        house = Integer.parseInt(br.readLine());
//        houseRGB = new int[house][RGB];
//
//        for (int i = 0; i < house; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            for (int j = 0; j < RGB; j++) {
//                houseRGB[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        int[] check = new int[RGB];
//
//        check[0] = sum(0, 0);
//        check[1] = sum(1, 0);
//        check[2] = sum(2, 0);
//
//        System.out.println(Math.min(check[2], Math.min(check[0], check[1])));
//    }
//
//    public static int sum(int use, int houseCount) {
//
//        if (houseCount == house - 1) {
//            System.out.println("return");
//            return houseRGB[houseCount][use];
//        }
//
//        if (use == 0) return houseRGB[houseCount][use] + Math.min(sum(1, houseCount + 1), sum(2, houseCount + 1));
//        else if (use == 1) return houseRGB[houseCount][use] + Math.min(sum(2, houseCount + 1), sum(0, houseCount + 1));
//        else return houseRGB[houseCount][use] + Math.min(sum(0, houseCount + 1), sum(1, houseCount + 1));
//    }
//}
