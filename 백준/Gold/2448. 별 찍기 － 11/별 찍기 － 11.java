import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = n / 3;


        int value = 1;
        while (true) {
            if (value == k) {
                break;
            }
            value = 2 * value;
        }

        array = new char[n][value * 5 + (value - 1)];

        for (int i = 0; i < array.length; i++) {
            Arrays.fill(array[i], ' ');
        }


        divide(0, 0, value);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                sb.append(array[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void divide(int startX, int startY, int value) {

        if (value == 1) {
            draw(startX, startY);
        } else {
            value = value / 2;
            divide(startX, startY + value * 3, value);
            divide(startX + value * 3, startY, value);
            divide(startX + value * 3, startY + value * 5 + value, value);
        }

    }

    public static void draw(int startX, int startY) {
        // 첫째 줄
        array[startX][startY + 2] = '*';
        // 둘째 줄
        array[startX + 1][startY + 1] = '*';
        array[startX + 1][startY + 3] = '*';
        // 셋째 줄
        array[startX + 2][startY] = '*';
        array[startX + 2][startY + 1] = '*';
        array[startX + 2][startY + 2] = '*';
        array[startX + 2][startY + 3] = '*';
        array[startX + 2][startY + 4] = '*';
    }
}