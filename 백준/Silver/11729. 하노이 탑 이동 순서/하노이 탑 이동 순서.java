import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int moveCount = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 2, 3);
        System.out.println(moveCount);
        System.out.print(sb);
    }

    public static void hanoi(int n, int start, int tmp, int end) {
        if (n == 1) {
            moveCount++;
            sb.append(start).append(" ").append(end).append("\n");
        } else {
            hanoi(n - 1, start, end, tmp);
            hanoi(1, start, tmp, end);
            hanoi(n - 1, tmp, start, end);
        }
    }
}

class Move {
    int x;
    int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}