import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int lt = 1;
        int rt = 2;

        StringBuilder sb = new StringBuilder();
        boolean check = false;

        while (lt < rt) {
            int value = rt * rt - lt * lt;

            if (value < g) {
                rt++;
            } else if (value > g) {
                lt++;
            } else {
                check = true;
                sb.append(rt).append("\n");
                lt++;
                rt++;
            }
        }

        System.out.print(check ? sb : -1);
    }
}