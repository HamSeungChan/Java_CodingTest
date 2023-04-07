class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int x = i;
                int y = yellow / i;

                int sum = x * 2 + y * 2 + 4;
                if (brown == sum) {
                    answer = new int[]{Math.max(x+2,y+2),Math.min(x+2,y+2)};
                    break;
                }
            }
        }

        return answer;
    }
}