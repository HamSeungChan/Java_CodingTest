import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String search = bf.readLine();
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() == search.length()) {
                if (search.equals(sb.toString())) {
                    answer++;
                    sb.delete(0, sb.length());
                }
                else{
                    sb.delete(0,1);
                }

            }
        }
        System.out.println(answer);
    }
}
