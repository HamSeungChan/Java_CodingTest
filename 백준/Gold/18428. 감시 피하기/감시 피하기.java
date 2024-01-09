import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String answer = "NO";
    static boolean flag;
    static List<Point> teachers = new ArrayList<>();
    static List<Point> emptySpace = new ArrayList<>();
    static String[][] array;
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new String[n][n];
        StringTokenizer token;


        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = token.nextToken();
                if (array[i][j].equals("T")) {
                    teachers.add(new Point(i, j));
                }
                if (array[i][j].equals("X")) {
                    emptySpace.add(new Point(i, j));
                }
            }
        }

        combination(0, 0, new int[3]);
        System.out.println(answer);
    }


    public static void combination(int index, int start, int[] pick) {

        if (flag) {
            return;
        }

        if (index == 3) {
            if (canPass(pick)) {
                answer = "YES";
                flag = true;
            }

        } else {
            for (int i = start; i < emptySpace.size(); i++) {
                pick[index] = i;
                combination(index + 1, i + 1, pick);
            }

        }
    }


    public static boolean canPass(int[] pick) {

        for (int i : pick) {

            Point tmp = emptySpace.get(i);
//            System.out.print(tmp.x + " " + tmp.y + " ");
            array[tmp.x][tmp.y] = "W";

        }
//        System.out.println();


//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }

        if (!isStudent()) {

            return true;
        }


        for (int i : pick) {
            Point tmp = emptySpace.get(i);
            array[tmp.x][tmp.y] = "X";
        }

        return false;
    }

    public static boolean isStudent() {
        for (Point tmp : teachers) {
            for (int i = tmp.x - 1; i >= 0; i--) {

                if (array[i][tmp.y].equals("W")) {
                    break;
                }

                if (array[i][tmp.y].equals("S")) {
                    return true;
                }
            }

            for (int i = tmp.x + 1; i < n; i++) {

                if (array[i][tmp.y].equals("W")) {
                    break;
                }

                if (array[i][tmp.y].equals("S")) {
                    return true;
                }
            }

            for (int i = tmp.y - 1; i >= 0; i--) {

                if (array[tmp.x][i].equals("W")) {
                    break;
                }

                if (array[tmp.x][i].equals("S")) {
                    return true;
                }
            }

            for (int i = tmp.y + 1; i < n; i++) {

                if (array[tmp.x][i].equals("W")) {
                    break;
                }

                if (array[tmp.x][i].equals("S")) {
                    return true;
                }
            }
        }
        return false;
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