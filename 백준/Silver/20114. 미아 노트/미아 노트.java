import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int h = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());

        String[] strings = new String[n];
        Arrays.fill(strings, "?");

        for (int i = 0; i < h; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < tmp.length; j++) {
                if(!tmp[j].equals("?")){
                    strings[j/w] = tmp[j];
                }
            }
        }
        for (String s : strings) {
            System.out.print(s);
        }

    }
}