import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 바보처럼 n 이중 포문으로 탐색해서 시간초과 발생
 * 탐색 시간을 어떻게 줄여야할지? 이분 탐색
 * */

public class Main {

    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int t = Integer.parseInt(token.nextToken());


        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            List<Integer> list = graph.get(x);
            list.add(y);

        }

        System.out.println(bfs(t));
    }

    public static int bfs(int t) {
        int depth = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));

        while (!q.isEmpty()) {

            int size = q.size();
            for (int s = 0; s < size; s++) {

                Point tmp = q.poll();
                if (tmp.y == t) {
                    return depth;
                }

                for (int nextX = tmp.x - 2; nextX <= tmp.x + 2; nextX++) {
                    if (nextX < 0 || nextX > 1000000) {
                        continue;
                    }
                    if (!graph.containsKey(nextX)) {
                        continue;
                    }

                    List<Integer> list = graph.get(nextX);
                    for (int j = list.size() - 1; j >= 0; j--) {
                        int nextY = list.get(j);
                        if (Math.abs(tmp.y - nextY) <= 2) {
                            list.remove(j);
                            q.offer(new Point(nextX, nextY));
                        }
                    }
                }
            }
            depth++;
        }
        return -1;
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}