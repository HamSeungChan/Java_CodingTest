import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for (int x : d) {
            if (budget - x >= 0) {
                answer++;
                budget = budget - x;
            }
        }
        return answer;
    }
}