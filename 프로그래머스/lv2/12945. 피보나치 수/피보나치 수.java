class Solution {

    static int[] dp;

    public int solution(int n) {
        int answer = 0;
        dp = new int[n + 1];
        return fibonacci(n);
    }

    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (dp[n] != 0) return dp[n];

        return dp[n] = (fibonacci(n - 2) % 1234567 + fibonacci(n - 1) % 1234567) % 1234567;
    }
}