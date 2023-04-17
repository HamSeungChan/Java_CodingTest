

import java.util.ArrayList;
import java.util.List;

class Solution {

    int[] array = new int[2];
    List<Point> list = new ArrayList<>();

    public String[] solution(int[][] line) {

        DFS(0, 0, line);
        Point minP = findGraphSize(list);
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        char[][] starGraph = new char[1][1];
        for (Point p : list) {
            p.x = p.x - minP.x;
            p.y = p.y - minP.y;
            maxX = Long.max(maxX, p.x);
            maxY = Long.max(maxY, p.y);
            //System.out.println(p.x + " " + p.y);
            starGraph = new char[(int)maxY + 1][(int)maxX + 1];
            System.out.println();
            for (int i = 0; i < maxY + 1; i++) {
                for (int j = 0; j < maxX + 1; j++) {
                    starGraph[i][j] = '.';
                }
            }
        }

        for (Point p : list) {
            System.out.println(p.x + " " + p.y);
            starGraph[(int)(maxY - p.y)][(int)p.x] = '*';
        }
        String[] answer = new String[(int)maxY + 1];
        for (int i = 0; i < maxY + 1; i++) {
            String s = "";
            for (int j = 0; j < maxX + 1; j++) {
                s += starGraph[i][j];
            }
            answer[i] = s;
        }
        return answer;
    }

    public void DFS(int layer, int value, int[][] line) {

        if (layer == 2) {
            long a = line[array[0]][0];
            long b = line[array[0]][1];
            long c = line[array[1]][0];
            long d = line[array[1]][1];
            long e = line[array[0]][2];
            long f = line[array[1]][2];

            if (a * d - b * c == 0) return;

            double x = (double) (b * f - e * d) / (a * d - b * c);
            double y = (double) (e * c - a * f) / (a * d - b * c);
            if (x % 1.0 == 0.0 && y % 1.0 == 0.0) {
                list.add(new Point((long) x, (long) y));
            }

        } else {
            for (int i = value; i < line.length; i++) {
                array[layer] = i;
                DFS(layer + 1, i + 1, line);
            }
        }
    }

    public Point findGraphSize(List<Point> list) {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        for (Point p : list) {
            minX = Math.min(p.x, minX);
            minY = Math.min(p.y, minY);
        }
        return new Point(minX, minY);
    }
}


class Point {
    long x;
    long y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
