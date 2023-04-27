import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();
        long y = sc.nextInt();
        long w = sc.nextInt();
        long s = sc.nextInt();

        long square = Math.min(x, y);
        long squareMove = Math.min(square * 2 * w, square * s);

        long line = Math.max(x, y) - square;
        long lineDistance;
        if (line % 2 == 0) {
            lineDistance = line * s;
        } else {
            lineDistance = (line - 1) * s + w;
        }
        long lineMove = Math.min(line * w, lineDistance);

        System.out.println(squareMove + lineMove);
    }

}


