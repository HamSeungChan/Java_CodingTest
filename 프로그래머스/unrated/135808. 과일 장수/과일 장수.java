import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int apple_count = score.length;
        int box_count = apple_count / m;
        for(int i=0; i< box_count; i++) {
        	answer += score[apple_count - m] * m;
        	apple_count -= m;
        }
        return answer;
    }
}