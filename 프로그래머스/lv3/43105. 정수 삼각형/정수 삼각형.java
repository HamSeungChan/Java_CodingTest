class Solution {

    static int[][] dp;

    public int solution(int[][] triangle) {

        dp = new int[triangle.length][triangle[triangle.length-1].length];
        return move(triangle,0,0);
    }

    public int move(int[][] triangle, int depth, int value) {

        if(depth == triangle.length - 1) return triangle[depth][value];
        if(dp[depth][value] != 0) return dp[depth][value];

        return dp[depth][value]= triangle[depth][value] + Math.max(move(triangle,depth+1,value)
                ,move(triangle,depth+1,value+1));
    }

}