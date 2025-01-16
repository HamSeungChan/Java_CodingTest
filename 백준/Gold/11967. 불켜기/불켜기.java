import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        boolean[][] map = new boolean[n + 1][n + 1];
        boolean[][] check = new boolean[n + 1][n + 1];
        Map<Info, List<Info>> infoMap = new HashMap<>();

        for (int i = 0; i < m; i++) {

            token = new StringTokenizer(br.readLine(), " ");
            Info from = new Info(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
            Info to = new Info(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));

            // 기존에 정보가 없다면
            if (!infoMap.containsKey(from)) {
                infoMap.put(from, new ArrayList<>());
                infoMap.get(from).add(to);
            }
            // 기존에 정보가 있다면
            else {
                infoMap.get(from).add(to);
            }
        }

        int answer = 1;
        map[1][1] = true;
        check[1][1] = true;
        Queue<Info> q = new ArrayDeque<>();
        q.add(new Info(1, 1));

        while (!q.isEmpty()) {

            Info now = q.poll();

            if (infoMap.containsKey(now)) {
                List<Info> infos = infoMap.get(now);
                for (Info info : infos) {

                    if (map[info.x][info.y]) {
                        continue;
                    }

                    // 불을 킨다.
                    answer++;
                    map[info.x][info.y] = true;

                    // 근처에 불이 켜진 집을 확인하고 있으면 큐에 넣는다.
                    boolean flag = false;
                    for (int i = 0; i < 4; i++) {

                        int moveX = info.x + MOVE_X[i];
                        int moveY = info.y + MOVE_Y[i];

                        if (1 <= moveX && moveX <= n && 1 <= moveY && moveY <= n && check[moveX][moveY]) {
                            q.add(info);
                            check[info.x][info.y] = true;
                            flag = true;
                        }
                        if (flag) break;
                    }
                }
            }

            // 불이켜진 방을 업데이트 후 이동한다.
            // 위에서 check 배열을 확인해 중복을 막는다.
            for (int i = 0; i < 4; i++) {
                int moveX = now.x + MOVE_X[i];
                int moveY = now.y + MOVE_Y[i];

                if (1 <= moveX && moveX <= n && 1 <= moveY && moveY <= n && !check[moveX][moveY] && map[moveX][moveY]) {
                    check[moveX][moveY] = true;
                    q.add(new Info(moveX, moveY));
                }
            }
        }

        System.out.println(answer);
    }
}

class Info {
    int x;
    int y;

    public Info(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return x == info.x && y == info.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}