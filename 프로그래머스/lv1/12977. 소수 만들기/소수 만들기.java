
class Solution {

    static int answer = 0;

    public int solution(int[] nums) {
        int[] array = new int[3];
        DFS(array, nums, 0, 0);

        return answer;
    }

    public void DFS(int[] array, int[] nums, int start, int value) {

        if (value == array.length) {
            int sum = 0;
            for (int x : array) {
                sum += x;
            }
            boolean isPrime = true;
            for (int i = 2; i < sum; i++) {
                if (sum % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) answer++;
        } else {
            for (int i = start; i < nums.length; i++) {
                array[value] = nums[i];
                DFS(array, nums, i + 1, value + 1);
            }
        }
    }
}