import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();

        String[] ss = string.split("-");
        int[] number = new int[ss.length];

        for (int i = 0; i < ss.length; i++) {
            String[] pluss = ss[i].split("\\+");
            for (String plus : pluss) {
                number[i] += Integer.parseInt(plus);
            }
        }

        int answer = number[0];
        for (int i = 1; i < number.length; i++) {
            answer -= number[i];
        }

        System.out.println(answer);
    }
}
