import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int s;
    static int[] array;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        s = Integer.parseInt(token.nextToken());
        array = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        powerSet(0, 0, 0);
        System.out.println(answer);
    }

    public static void powerSet(int index, int zeroCount, int sum) {
        if (index == n) {
            if(zeroCount != n && sum == s){
                answer++;
            }
        } else {
            powerSet(index + 1, zeroCount, sum + array[index]);
            powerSet(index + 1, zeroCount + 1, sum);
        }
    }
}