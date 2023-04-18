
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    answer++;
                    DFS(i, n, computers);
                }
            }
        }
        return answer;
    }

    public void DFS(int v, int n, int[][] computers) {
    
       for (int i = 0; i < n; i++) {
            if (computers[v][i] == 1) {
                computers[v][i] = 0;
                computers[i][v] = 0;

                DFS(i, n, computers);
            }
        }
    }
}