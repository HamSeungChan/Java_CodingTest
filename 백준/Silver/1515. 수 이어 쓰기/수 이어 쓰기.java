import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();

        int now = 1;
        int index = 0;
        boolean stop = false;

        while (true) {

            String nowString = String.valueOf(now);
            for (int i = 0; i < nowString.length(); i++) {
                if (array[index] == nowString.charAt(i)) {
                    index++;
                    if (index == array.length) {
                        stop = true;
                        break;
                    }
                }
            }

            if (stop){
                break;
            }

            now++;
        }
        System.out.println(now);
    }
}