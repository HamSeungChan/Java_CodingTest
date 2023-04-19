
import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    public int[][] solution(int n) {
        List<Point> list = new ArrayList<>();
        list = move(1, 3, n);
        int [][] answer = new int[list.size()][2];
        for(int i=0; i<list.size();i++){
            answer[i][0] = list.get(i).start;
            answer[i][1] = list.get(i).end;
        }
        return answer;
    }

    public List<Point> move(int start, int goal, int n) {
        List<Point> tmp = new ArrayList<>();
        int[] check = new int[4];
        int via = 0;
        check[start] = 1;
        check[goal] = 1;
        for (int i = 1; i < 4; i++) {
            if (check[i] == 0) via = i;
        }
        if (n == 1) {
            tmp.add(new Point(start, goal));
            return tmp;
        }
        if (n == 2) {
            tmp.add(new Point(start, via));
            tmp.add(new Point(start, goal));
            tmp.add(new Point(via, goal));
            return tmp;
        }
        tmp.addAll(move(start, via, n - 1));
        tmp.addAll(move(start, goal, 1));
        tmp.addAll(move(via, goal, n - 1));
        return tmp;
    }
}

class Point {
    int start;
    int end;

    Point(int start, int end) {
        this.start = start;
        this.end = end;
    }
}