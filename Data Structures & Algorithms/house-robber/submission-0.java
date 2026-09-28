class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];
        return solve(0, nums, dp);
    }

    public int solve(int idx, int[] nums, Integer[] dp){
        if(idx >= nums.length) return 0;

        if(dp[idx] != null) return dp[idx];

        //option1 
        int op1 = nums[idx] + solve(idx + 2, nums, dp);

        //option2
        int op2 = solve(idx + 1, nums, dp);

        return dp[idx] = Math.max(op1, op2);
    }
}
