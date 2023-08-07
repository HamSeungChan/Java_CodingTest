import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int[][] array;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        array = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            array[x][y] = 1;
            array[y][x] = 1;
        }

        int answer = Integer.MAX_VALUE;
        int realAnswer = 0;

        for (int i = 1; i <= n; i++) {
            int result = BFS(i);
            if (result < answer) {
                answer = result;
                realAnswer = i;
            }
        }

        System.out.println(realAnswer);
    }

    public static int BFS(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] checkPeople = new boolean[n + 1];

        deque.add(start);
        checkPeople[start] = true;
        int level = 0;
        int sum = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            for (int i = 0; i < size; i++) {
                int tmp = deque.poll();
                for (int j = 1; j <= n; j++) {
                    if (array[tmp][j] == 1 && !checkPeople[j]) {
                        checkPeople[j] = true;
                        deque.add(j);
                        sum += level;
                    }
                }
            }
        }

        return sum;

    }

}