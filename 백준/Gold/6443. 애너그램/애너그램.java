import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] check;
    static Set<String> set;
    static StringBuilder print = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            set = new HashSet<>();
            char[] word = br.readLine().toCharArray();
            Arrays.sort(word);
            check = new int[26];

            for (char c : word) {
                check[c - 'a']++;
            }
            int[] answer = new int[word.length];
            dfs(word.length, 0, answer);
        }
        System.out.print(print);
    }

    private static void dfs(int wordLength, int depth, int[] answer) {
        if (wordLength == depth) {
            StringBuilder sb = new StringBuilder();
            for (int i : answer) {
                sb.append((char) (i + 'a'));
            }
            String tmp = sb.toString();
            if (!set.contains(tmp)) {
                print.append(tmp).append("\n");
                set.add(tmp);
            }
        } else {
            for (int i = 0; i < check.length; i++) {
                if (check[i] > 0) {
                    check[i]--;
                    answer[depth] = i;
                    dfs(wordLength, depth + 1, answer);
                    check[i]++;
                }
            }
        }
    }
}