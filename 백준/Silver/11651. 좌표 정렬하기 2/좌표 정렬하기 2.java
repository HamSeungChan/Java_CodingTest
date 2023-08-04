import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            pointList.add(new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
        Collections.sort(pointList);
        for (Point p : pointList) {
            System.out.println(p.x + " " + p.y);
        }
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
        if (this.y == o.y) {
            return this.x - o.x;
        }
        return this.y - o.y;
    }
}