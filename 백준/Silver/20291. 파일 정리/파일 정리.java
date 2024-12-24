import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        StringTokenizer token;
        for (int i = 0; i < n; i++) {

            token = new StringTokenizer(br.readLine(), ".");
            token.nextToken();
            String s = token.nextToken();

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet()) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}