class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        Integer[][] dp = new Integer[n+1][amount+1];
        return solve(0, amount, coins, dp);
    }

    public int solve(int idx, int amount, int[] coins, Integer[][] dp){
        if(idx == coins.length || amount < 0) return 0;

        if(amount == 0) return 1;

        if(dp[idx][amount] != null) return dp[idx][amount];

        //option1 
        int op1 = solve(idx, amount-coins[idx], coins, dp);

        //option2
        int op2 = solve(idx+1, amount, coins, dp);

        return dp[idx][amount] = op1 + op2;
    }
}
