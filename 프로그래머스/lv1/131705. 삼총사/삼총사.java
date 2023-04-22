
class Solution {

    int answer = 0;
    int totalStudent;

    public int solution(int[] number) {
        totalStudent = number.length;
        int [] check = new int[3];
        DFS(0,0,number,check);
        return answer;
    }

    public void DFS(int value, int start, int[] number, int[] check) {
        if (value == check.length) {
            int sum = 0;
            for (int x : check) {
                sum += x;
            }
            if (sum == 0)
                answer++;
        } else {
            for (int i = start; i < totalStudent; i++) {
                check[value] = number[i];
                DFS(value + 1, i+1, number, check);
            }
        }
    }
}