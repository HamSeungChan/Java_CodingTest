import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i = 1;
        int check = 0;
        while (true) {
            String s = String.valueOf(i);
            if(s.contains("666")){
                check++;
            }
            if(check == n){
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}