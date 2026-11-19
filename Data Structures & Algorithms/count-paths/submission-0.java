class Solution {
    int N;
    int M;
    public int uniquePaths(int m, int n) {
        M = m;
        N = n;
        Integer[][] dp = new Integer[M][N];
        return solve(0, 0, dp);
    }

    public int solve(int x, int y, Integer[][] dp){
        if(x == M-1 && y == N-1) return 1;
        if(x == M || y == N) return 0;

        if(dp[x][y] != null) return dp[x][y];

        int op1 = solve(x+1, y, dp);
        int op2 = solve(x, y+1, dp);

        return dp[x][y] = op1+op2;
    }
}
