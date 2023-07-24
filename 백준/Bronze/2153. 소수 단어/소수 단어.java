import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String answer = "It is a prime word.";
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sum += c - 38;
            } else {
                sum += c - 96;
            }
        }
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                answer = "It is not a prime word.";
                break;
            }
        }
        System.out.println(answer);
    }
}