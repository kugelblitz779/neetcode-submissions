class Solution {
    int N;
    public int climbStairs(int n) {
        N = n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return dfs(n, dp);
    }

    public int dfs(int idx, int[] dp){

        if(idx == 0) return 1;
        if(idx == 1) return 1;

        if(dp[idx] != -1) return dp[idx];

        return dp[idx] = dfs(idx-1, dp) + dfs(idx-2, dp);
    }
}
