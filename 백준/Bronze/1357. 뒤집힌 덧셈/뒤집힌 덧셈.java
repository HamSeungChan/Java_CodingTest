import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        StringBuilder x =  new StringBuilder(token.nextToken());
        StringBuilder y =  new StringBuilder(token.nextToken());

        int value = Integer.parseInt(x.reverse().toString()) + Integer.parseInt(y.reverse().toString());
        System.out.println(Integer.parseInt(new StringBuilder(String.valueOf(value)).reverse().toString()));
    }
}