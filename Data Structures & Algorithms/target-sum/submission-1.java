class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for(int i=0; i<n; i++){ 
            dp[i] = new HashMap<>();
        }
        return dfs(0, nums, target, dp);
    }

    public int dfs(int idx, int[] nums, int target, Map<Integer, Integer>[] dp){
        if(idx == nums.length) return target == 0 ? 1 : 0;
        Integer cached = dp[idx].get(target);

        if(cached != null) return cached;
        
        int ways = 0;
        if(idx < nums.length){
            ways = dfs(idx+1, nums, target+nums[idx], dp) + dfs(idx+1, nums, target-nums[idx], dp);
        }
        
        dp[idx].put(target, ways);
        return ways;
    }
}
