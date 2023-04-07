class Solution {
    public int solution(int n) {
        int head = 1;
        int sum = 0;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;

            while (sum > n) {
                sum -= head;
                head++;
            }

            if (sum == n) {
                answer++;
            }
        }
        return answer;
    }
}