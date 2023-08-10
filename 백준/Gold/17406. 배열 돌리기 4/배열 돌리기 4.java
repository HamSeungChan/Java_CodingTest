import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Info {
        int r, c, s;
        int stY, stX, enY, enX;

        public Info(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.stY = r - s;
            this.stX = c - s;
            this.enY = r + s;
            this.enX = c + s;
        }
    }

    public static int N, M, K, r, c, s, answer;
    public static boolean[] isUsed;
    public static int[] sequence;
    public static Info[] infoArr;
    public static int[][] arr, copyArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isUsed = new boolean[K];
        sequence = new int[K];
        infoArr = new Info[K];
        arr = new int[N][M];

        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());

            infoArr[i] = new Info(Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()));
        }

        permutation(0);

        System.out.println(answer);
    }

    public static void permutation(int cnt) {
        if (cnt == K) {

            copyArr = new int[N][M];
            copy(arr, copyArr);

            for (int i = 0; i < K; ++i) {

                int stY = infoArr[sequence[i]].stY;
                int stX = infoArr[sequence[i]].stX;
                int enY = infoArr[sequence[i]].enY;
                int enX = infoArr[sequence[i]].enX;


                while (stY < enY && stX < enX) {
                    turn(stY++, stX++, enY--, enX--);
                }
            }

            getMin();
            return;
        }

        for (int i = 0; i < K; ++i) {
            if (isUsed[i]) {
                continue;
            }

            isUsed[i] = true;
            sequence[cnt] = i;
            permutation(cnt + 1);
            isUsed[i] = false;
        }
    }

    public static int[] dy = {1, 0, -1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static void turn(int stY, int stX, int enY, int enX) {
        int y = stY;
        int x = stX;
        int dir = 0;


        int temp = copyArr[y][x];

        while (dir < 4) {
            // 전진
            int ny = y + dy[dir];
            int nx = x + dx[dir];


            if (ny == stY && nx == stX) {
                copyArr[y][x] = temp;
                return;
            }


            if (ny < stY || nx < stX || ny > enY || nx > enX) {
                dir++;
                continue;
            }


            copyArr[y][x] = copyArr[ny][nx];


            y = ny;
            x = nx;
        }
    }


    public static void copy(int[][] origin, int[][] target) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                target[i][j] = origin[i][j];
            }
        }
    }


    public static void getMin() {
        for (int i = 0; i < N; ++i) {
            int sum = 0;

            for (int j = 0; j < M; ++j) {
                sum += copyArr[i][j];
            }

            answer = (answer > sum) ? sum : answer;
        }
    }
}