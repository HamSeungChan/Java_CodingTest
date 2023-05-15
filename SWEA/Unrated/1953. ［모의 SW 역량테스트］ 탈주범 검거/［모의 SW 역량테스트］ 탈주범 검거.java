import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {

    static final int[] MOVE_X = {0, 1, 0, -1};
    static final int[] MOVE_Y = {1, 0, -1, 0};
    static int[][] graph;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            n = Integer.parseInt(tokenizer.nextToken());
            m = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            int l = Integer.parseInt(tokenizer.nextToken());

            graph = new int[n][m];

            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    graph[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(r, c));
            int time = 1;
            int[][] check = new int[n][m];
            check[r][c] =1;
            while (!q.isEmpty()) {
                if (time == l) {
                    break;
                }
                int qSize = q.size();
                for (int i = 0; i < qSize; i++) {
                    Point tmp = q.poll();
                    if (graph[tmp.x][tmp.y] == 1) {
                        if (canMoveRight(tmp) && check[tmp.x][tmp.y + 1] == 0) {
                            q.offer(new Point(tmp.x, tmp.y + 1));
                            check[tmp.x][tmp.y + 1] = 1;
                        }
                        if (canMoveDown(tmp) && check[tmp.x + 1][tmp.y] == 0) {
                            q.offer(new Point(tmp.x + 1, tmp.y));
                            check[tmp.x + 1][tmp.y] = 1;
                        }
                        if (canMoveLeft(tmp) && check[tmp.x][tmp.y - 1] == 0) {
                            q.offer(new Point(tmp.x, tmp.y - 1));
                            check[tmp.x][tmp.y - 1] = 1;
                        }
                        if (canMoveUp(tmp) && check[tmp.x - 1][tmp.y] == 0) {
                            q.offer(new Point(tmp.x - 1, tmp.y));
                            check[tmp.x - 1][tmp.y] = 1;
                        }
                    } else if (graph[tmp.x][tmp.y] == 2) {
                        if (canMoveDown(tmp) && check[tmp.x + 1][tmp.y] == 0) {
                            q.offer(new Point(tmp.x + 1, tmp.y));
                            check[tmp.x + 1][tmp.y] = 1;
                        }
                        if (canMoveUp(tmp) && check[tmp.x - 1][tmp.y] == 0) {
                            q.offer(new Point(tmp.x - 1, tmp.y));
                            check[tmp.x - 1][tmp.y] = 1;
                        }
                    } else if (graph[tmp.x][tmp.y] == 3) {
                        if (canMoveLeft(tmp) && check[tmp.x][tmp.y - 1] == 0) {
                            q.offer(new Point(tmp.x, tmp.y - 1));
                            check[tmp.x][tmp.y - 1] = 1;
                        }
                        if (canMoveRight(tmp) && check[tmp.x][tmp.y + 1] == 0) {
                            q.offer(new Point(tmp.x, tmp.y + 1));
                            check[tmp.x][tmp.y + 1] = 1;
                        }
                    } else if (graph[tmp.x][tmp.y] == 4) {
                        if (canMoveRight(tmp) && check[tmp.x][tmp.y + 1] == 0) {
                            q.offer(new Point(tmp.x, tmp.y + 1));
                            check[tmp.x][tmp.y + 1] = 1;
                        }
                        if (canMoveUp(tmp) && check[tmp.x - 1][tmp.y] == 0) {
                            q.offer(new Point(tmp.x - 1, tmp.y));
                            check[tmp.x - 1][tmp.y] = 1;
                        }
                    } else if (graph[tmp.x][tmp.y] == 5) {
                        if (canMoveDown(tmp) && check[tmp.x + 1][tmp.y] == 0) {
                            q.offer(new Point(tmp.x + 1, tmp.y));
                            check[tmp.x + 1][tmp.y] = 1;
                        }
                        if (canMoveRight(tmp) && check[tmp.x][tmp.y + 1] == 0) {
                            q.offer(new Point(tmp.x, tmp.y + 1));
                            check[tmp.x][tmp.y + 1] = 1;
                        }
                    } else if (graph[tmp.x][tmp.y] == 6) {
                        if (canMoveLeft(tmp) && check[tmp.x][tmp.y - 1] == 0) {
                            q.offer(new Point(tmp.x, tmp.y - 1));
                            check[tmp.x][tmp.y - 1] = 1;
                        }
                        if (canMoveDown(tmp) && check[tmp.x + 1][tmp.y] == 0) {
                            q.offer(new Point(tmp.x + 1, tmp.y));
                            check[tmp.x + 1][tmp.y] = 1;
                        }
                    } else {
                        if (canMoveLeft(tmp) && check[tmp.x][tmp.y - 1] == 0) {
                            q.offer(new Point(tmp.x, tmp.y - 1));
                            check[tmp.x][tmp.y - 1] = 1;
                        }
                        if (canMoveUp(tmp) && check[tmp.x - 1][tmp.y] == 0) {
                            q.offer(new Point(tmp.x - 1, tmp.y));
                            check[tmp.x - 1][tmp.y] = 1;
                        }
                    }
                }
                time++;
            }
            int answer = 0;
            for(int i= 0; i<n;i++){
                for(int j =0; j<m;j++){
                    if(check[i][j] == 1){
                        answer++;
                    }
                }
            }
            System.out.println("#"+(t+1)+" "+answer);
        }
    }

    static boolean canMoveRight(Point p) {
        int mX = p.x;
        int mY = p.y + 1;
        return mX >= 0 && mX < n && mY >= 0 && mY < m && (graph[mX][mY] == 3 || graph[mX][mY] == 6 || graph[mX][mY] == 7 || graph[mX][mY] == 1);
    }

    static boolean canMoveDown(Point p) {
        int mX = p.x + 1;
        int mY = p.y;
        return mX >= 0 && mX < n && mY >= 0 && mY < m && (graph[mX][mY] == 2 || graph[mX][mY] == 4 || graph[mX][mY] == 7 || graph[mX][mY] == 1);
    }

    static boolean canMoveLeft(Point p) {
        int mX = p.x;
        int mY = p.y - 1;
        return mX >= 0 && mX < n && mY >= 0 && mY < m && (graph[mX][mY] == 3 || graph[mX][mY] == 4 || graph[mX][mY] == 5 || graph[mX][mY] == 1);
    }

    static boolean canMoveUp(Point p) {
        int mX = p.x - 1;
        int mY = p.y;
        return mX >= 0 && mX < n && mY >= 0 && mY < m && (graph[mX][mY] == 2 || graph[mX][mY] == 5 || graph[mX][mY] == 6 || graph[mX][mY] == 1);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
