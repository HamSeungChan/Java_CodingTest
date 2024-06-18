import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static Point[] p;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        p = new Point[n];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            p[i] = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }

        Arrays.sort(p);
        int count = 0;
        for (Point point : p) {
            Point point1 = new Point(point.x + a, point.y);
            Point point2 = new Point(point.x, point.y + b);
            Point point3 = new Point(point.x + a, point.y + b);

            if (find(point1) && find(point2) && find(point3)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean find(Point tmp) {

        int lt = 0;
        int rt = p.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (p[mid].x < tmp.x || (p[mid].x == tmp.x && p[mid].y < tmp.y)) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

            if (p[mid].x == tmp.x && p[mid].y == tmp.y) {
                return true;
            }
        }
        return false;
    }

}

class Point implements Comparable<Point> {
    int x;
    int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}