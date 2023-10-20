import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();
        String bomb = br.readLine();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (answer.length() < bomb.length() - 1) {
                answer.append(array[i]);
                continue;
            }
            answer.append(array[i]);
            if (answer.substring(answer.length() - bomb.length()).equals(bomb)) {
                answer.delete(answer.length() - bomb.length(), answer.length());
            }
        }
        if (answer.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(answer);
        }

    }
}