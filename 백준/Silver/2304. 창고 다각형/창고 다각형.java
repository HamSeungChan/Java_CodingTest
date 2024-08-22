import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[1002];
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int position = Integer.parseInt(token.nextToken());
            int height = Integer.parseInt(token.nextToken());
            array[position] = height;

            start = Math.min(start, position);
            end = Math.max(end, position);
        }

        int[] leftMax = new int[1002];
        int[] rightMax = new int[1002];

        for (int i = start; i <= end; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], array[i]);
        }

        for (int i = end; i >= start; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], array[i]);
        }

        int answer = 0;
        for (int i = start; i <= end; i++) {
            answer += Math.min(leftMax[i], rightMax[i]);
        }
        System.out.println(answer);
    }
}