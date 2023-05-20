import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int l;
    static int[][] hamburger;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.valueOf(br.readLine());
        for (int test = 1; test <= test_case; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.valueOf(st.nextToken());
            l = Integer.valueOf(st.nextToken());

            hamburger = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                hamburger[i][0] = Integer.valueOf(st.nextToken());
                hamburger[i][1] = Integer.valueOf(st.nextToken());

            }
            DFS(0, 0, 0);
            System.out.println("#" + test + " " + answer);
            answer = Integer.MIN_VALUE;
        }
    }

    static void DFS(int start, int score, int calSum) {
        if (calSum > l) {
            return;
        }
        answer = Math.max(answer, score);
        if (start == n) {
            return;
        }
        DFS(start + 1, score + hamburger[start][0], calSum + hamburger[start][1]);
        DFS(start + 1, score, calSum);

    }
}
