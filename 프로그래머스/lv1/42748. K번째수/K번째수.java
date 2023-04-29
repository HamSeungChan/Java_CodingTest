import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] answer = new int[commands.length];
        int tmp = 0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] newArray = new int[j - i + 1];
            List<Integer> list = new ArrayList<>();
            for (int t = i-1; t <= j-1; t++){
                list.add(array[t]);
            }
            Collections.sort(list);
            answer[tmp] = list.get(k-1);
            tmp++;
        }
        return answer;
    }
}