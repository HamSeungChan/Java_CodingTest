class Solution {
    public int solution(int n) {
        int answer = 0;
        int countOne = Integer.bitCount(n);
        while (true) {
            n++;
            if (countOne == Integer.bitCount(n)) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}