import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n - 1];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.parseInt(token.nextToken());
        }

        int[] array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        long answer = (long) array[0] * distance[0];
        int min = array[0];

        for (int i = 1; i < distance.length; i++) {
            min = Math.min(min, array[i]);
            answer += (long) min * distance[i];
        }

        System.out.println(answer);

    }
}