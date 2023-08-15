import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[][] star;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        star = new String[n][n];
        takeStar(n, 0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(star[i][j] == null){
                    sb.append(" ");
                    continue;
                }
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void takeStar(int size, int startX, int startY) {

        if (size == 1) {

            star[startX][startY] = "*";

        } else {

            size /= 3;

            takeStar(size, startX, startY);
            takeStar(size, startX, startY + size);
            takeStar(size, startX, startY + size * 2);
            takeStar(size, startX + size, startY);
            takeStar(size, startX + size, startY + size * 2);
            takeStar(size, startX + size * 2, startY);
            takeStar(size, startX + size * 2, startY + size);
            takeStar(size, startX + size * 2, startY + size * 2);
        }


    }

}