class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] array = new int[n + 2];
        for (int x : lost) {
            array[x] += -1;
        }
        for (int x : reserve) {
            array[x] += 1;
        }

        for (int i = 1; i <= n; i++) {
            if (array[i] == -1) {
                if (array[i - 1] == 1) {
                    array[i] += 1;
                    array[i - 1] -= 1;
                    continue;
                    
                }
                if (array[i + 1] == 1) {
                    array[i] += 1;
                    array[i + 1] -= 1;
                }

            }
        }
        
        for(int i = 1; i<=n;i++){
            if(array[i] >=0) answer++;
        }

        return answer;
    }
}