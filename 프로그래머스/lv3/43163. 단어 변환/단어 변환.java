import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {

        int[] check = new int[words.length];
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        int count = 0;
        int answer = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                String tmp = q.poll();
                System.out.println(tmp);
                char[] charTmp = tmp.toCharArray();
                for (int j = 0; j < words.length; j++) {
                    if (check[j] == 0) {
                        char[] word = words[j].toCharArray();
                        int notSameCount = 0;
                        for (int t = 0; t < charTmp.length; t++) {
                            if (charTmp[t] != word[t]) notSameCount++;
                        }
                        if (notSameCount == 1) {
                            if (words[j].equals(target)) {
                                answer = count + 1;
                            }
                            check[j] = 1;
                            q.offer(words[j]);
                        }
                    }
                }
            }
            count++;
        }
        return answer;
    }
}