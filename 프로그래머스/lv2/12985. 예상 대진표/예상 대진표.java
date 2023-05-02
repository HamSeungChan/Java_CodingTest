class Solution {
    public int solution(long n, long a, long b) {
        int answer;
        int gameCount = 1;
        a -= 1;
        b -= 1;
        while (true) {
            a = a / 2;
            b = b / 2;
            if (a == b) {
                answer = gameCount;
                break;
            }
            gameCount++;
        }
        return answer;
    }
}