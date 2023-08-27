import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static int[] MOVE_X = {0, -1, 1, 0, 0};

    static int[] MOVE_Y = {0, 0, 0, 1, -1};

    static int r;
    static int c;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        List<Shark> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;
            int speed = Integer.parseInt(token.nextToken());
            int direction = Integer.parseInt(token.nextToken());
            int size = Integer.parseInt(token.nextToken());

            Shark shark = new Shark(r, c, speed, direction, size);
            list.add(shark);
        }


        int score = 0;

        for (int fishingKingLocation = 0; fishingKingLocation < c; fishingKingLocation++) {
            Shark[][] map = makeMap(list);
            score += fishing(fishingKingLocation, map);
            list = makeList(map);
        }

        System.out.println(score);
    }

    public static Shark[][] makeMap(List<Shark> list) {
        Shark[][] map = new Shark[r][c];
        for (Shark shark : list) {
            if (map[shark.i][shark.j] == null) {
                map[shark.i][shark.j] = shark;
            } else {
                if (map[shark.i][shark.j].size < shark.size) {
                    map[shark.i][shark.j] = shark;
                }
            }
        }

        return map;
    }

    public static int fishing(int location, Shark[][] map) {

        int fishSize = 0;

        for (int i = 0; i < r; i++) {
            if (map[i][location] != null) {           // 물고기가 존재한다면
                fishSize = map[i][location].size;     // 물고기의 size를 가져온다
                map[i][location] = null;              // 잡힌 물고리 자리 null로
                break;
            }
        }
        return fishSize;
    }

    public static Shark move(Shark shark) {

        int direction = shark.direction;
        int speed = shark.speed;
        int moveX = shark.i;
        int moveY = shark.j;

        for (int m = 0; m < speed; m++) {
            moveX = moveX + MOVE_X[direction];
            moveY = moveY + MOVE_Y[direction];

            if (moveX == r) {
                moveX = moveX - 2;
                direction = 1;
            } else if (moveX == -1) {
                moveX = moveX + 2;
                direction = 2;
            } else if (moveY == c) {
                moveY = moveY - 2;
                direction = 4;
            } else if (moveY == -1) {
                moveY = moveY + 2;
                direction = 3;
            }
        }

        shark.direction = direction;
        shark.i = moveX;
        shark.j = moveY;

        return shark;
    }

    public static List<Shark> makeList(Shark[][] map) {

        List<Shark> moveList = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != null) {
                    moveList.add(move(map[i][j]));
                }
            }
        }

        return moveList;
    }
}

class Shark {
    int i;
    int j;
    int speed;
    int direction;
    int size;

    public Shark(int i, int j, int speed, int direction, int size) {
        this.i = i;
        this.j = j;
        this.speed = speed;
        this.direction = direction;
        this.size = size;
    }
}