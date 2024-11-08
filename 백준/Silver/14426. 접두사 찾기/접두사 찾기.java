import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        List<Token> start = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] cArray = br.readLine().toCharArray();
            List<Token> nextList = start;
            for (char c : cArray) {

                boolean flag = false;
                for (Token next : nextList) {
                    if (next.c == c) {
                        nextList = next.nextToken;
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    continue;
                }

                Token newToken = new Token(c);
                nextList.add(newToken);
                nextList = newToken.nextToken;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {

            List<Token> nextList = start;
            char[] cArray = br.readLine().toCharArray();
            for (int j = 0; j < cArray.length; j++) {

                boolean flag = false;
                for (Token token1 : nextList) {
                    if (token1.c == cArray[j]) {
                        nextList = token1.nextToken;
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    break;
                }

                if (j == cArray.length - 1) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}

class Token {
    char c;
    List<Token> nextToken = new ArrayList<>();

    public Token(char c) {
        this.c = c;
    }
}