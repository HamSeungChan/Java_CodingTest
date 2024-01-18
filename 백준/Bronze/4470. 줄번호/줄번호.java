import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <=n; i++){
            String tmp = br.readLine();
            sb.append(i).append(".").append(" ").append(tmp).append("\n");
        }

        System.out.println(sb);

    }
}