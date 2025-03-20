import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[] MOVE_X = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] MOVE_Y = {-1, 0, 1, 1, 1, 0, -1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 5);
        }

        int[][] nutrients = new int[n][n];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                nutrients[i][j] = Integer.parseInt(token.nextToken());
            }
        }


        // init, 나무를 정보를 받는다.
        // 같은 칸에 여러 개의 나무가 심어져 있을 수도 있다.
        Queue<Tree> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            int age = Integer.parseInt(token.nextToken());

            pq.add(new Tree(x - 1, y - 1, age));
        }

        for (int i = 0; i < k; i++) {

            List<Tree> aliveTree = new ArrayList<>();
            List<Tree> deadTree = new ArrayList<>();
            List<Tree> breedingTree = new ArrayList<>();

            // 봄
            // 자신의 나이만큼 양분을 먹는다.
            // 나이가 1 증가한다.
            // 하나의 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
            // 양분이 부족해 자신의 나이만큼 먹을 수 없는 나무는 양분을 먹지 못하고 죽는다.
            while (!pq.isEmpty()) {
                Tree tree = pq.poll();

                if (map[tree.x][tree.y] >= tree.age) {

                    map[tree.x][tree.y] -= tree.age;
                    tree.age += 1;
                    aliveTree.add(tree);

                    if (tree.age % 5 == 0) {
                        breedingTree.add(tree);
                    }
                } else {
                    deadTree.add(tree);
                }
            }

            pq.addAll(aliveTree);

            // 여름
            // 봄에 죽은 나무가 양분으로 변한다.
            // 죽은 나무마다 나이를 2로 나눈 값이 양분으로 추가된다.
            for (Tree tree : deadTree) {
                map[tree.x][tree.y] += tree.age / 2;
            }

            // 가을
            // 나무 번식
            // 나이가 5의 배수면 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
            for (Tree tree : breedingTree) {

                for (int j = 0; j < MOVE_X.length; j++) {
                    int moveX = tree.x + MOVE_X[j];
                    int moveY = tree.y + MOVE_Y[j];

                    if (inRange(moveX, moveY)) {
                        pq.add(new Tree(moveX, moveY, 1));
                    }
                }
            }

            // 겨울
            // 양분을 추가한다.
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    map[a][b] += nutrients[a][b];
                }
            }
        }

        System.out.println(pq.size());
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}

class Tree implements Comparable<Tree> {

    int x;
    int y;
    int age;

    public Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }

    @Override
    public int compareTo(Tree o) {
        return this.age - o.age;
    }
}
