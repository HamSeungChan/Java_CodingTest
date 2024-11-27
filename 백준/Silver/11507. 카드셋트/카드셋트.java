import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] check = new boolean[4][14];
        int[] count = new int[4];

        String tmp = br.readLine();
        for (int i = 0; i < tmp.length(); i += 3) {
            String substring = tmp.substring(i, i + 3);
            int index = -1;
            switch (substring.charAt(0)) {
                case 'P':
                    index = 0;
                    break;
                case 'K':
                    index = 1;
                    break;
                case 'H':
                    index = 2;
                    break;
                case 'T':
                    index = 3;
            }
            int value = (substring.charAt(1) - '0') * 10 + substring.charAt(2) - '0';
            if (!check[index][value]) {
                count[index]++;
                check[index][value] = true;
            } else {
                System.out.println("GRESKA");
                System.exit(0);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i1 : count) {
            sb.append(13 - i1).append(" ");
        }
        System.out.print(sb);
    }
}