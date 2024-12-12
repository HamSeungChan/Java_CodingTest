import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int GCD(int n1, int n2) {
        if (n2 == 0) return n1;
        else return GCD(n2, n1 % n2);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken()); //동생의 수
        int s = Integer.parseInt(token.nextToken()); //나의 위치
        int[] arr = new int[n];

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(token.nextToken()); //동생의 위치
            arr[i] = Math.abs(s - a); // 내위치와 동생의 위치 차이 저장
        }

        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = GCD(gcd, arr[i]);
        }
        System.out.println(gcd);

    }

}