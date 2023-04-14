class Solution {

    static int answer = 0;

    public void DFS(int value, int[] numbers, int sum, int target) {
        if (value == numbers.length) {
            if (sum == target) {
                answer++;
            }
        } else {
            DFS(value + 1, numbers, sum + numbers[value], target);
            DFS(value + 1, numbers, sum - numbers[value], target);
        }
    }

    public int solution(int[] numbers, int target) {
        DFS(0,numbers,0,target);
        return answer;
    }
}