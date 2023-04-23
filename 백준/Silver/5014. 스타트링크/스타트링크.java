import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int buildingHeight;
    static int start;
    static int startLink;
    static int up;
    static int down;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        buildingHeight = sc.nextInt();
        start = sc.nextInt();
        startLink = sc.nextInt();
        up = sc.nextInt();
        down = sc.nextInt();
        int[] checkHeight = new int[buildingHeight + 1];
        int answer = new Main().BFS(checkHeight);
        if (answer == -1) {
            System.out.println("use the stairs");
        } else
            System.out.println(answer);
    }

    public int BFS(int[] checkHeight) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        checkHeight[start] = 1;
        int moveCount = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int tmp = q.poll();
                if (tmp == startLink) {
                    return moveCount;
                }
                int moveUp = tmp + up;
                int moveDown = tmp - down;

                if (moveUp <= buildingHeight && checkHeight[moveUp] == 0) {
                    q.offer(moveUp);
                    checkHeight[moveUp] = 1;
                }
                if (moveDown > 0 && checkHeight[moveDown] == 0) {
                    q.offer(moveDown);
                    checkHeight[moveDown] = 1;
                }
            }
            moveCount++;
        }
        return -1;
    }
}
