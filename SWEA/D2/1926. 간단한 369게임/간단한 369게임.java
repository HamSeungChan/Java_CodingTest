import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            String[] array = String.valueOf(i).split("");

            int count = 0;
            for (String s : array) {
                int number = Integer.valueOf(s);
                if (number % 3 == 0 && number > 0) {
                    count++;
                }

            }
                if (count > 0) {
                    for (int j = 0; j < count; j++) {
                        sb.append("-");
                    }
                } else {
                    sb.append(i);
                }

                sb.append(" ");

        }
        System.out.println(sb.toString().trim());
    }
}