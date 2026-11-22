class Solution {
    final int INF = Integer.MAX_VALUE/2;
    public int coinChange(int[] coins, int amount) {
        Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();
        int ans = solve(0, coins, amount, dp);
        return ans == INF ? -1 : ans;
    }

    public int solve(int idx, int[] coins, int amount, Map<Pair<Integer,Integer>, Integer> dp){

        if(amount < 0 || idx >= coins.length) return INF;
        if(amount == 0) return 0;

        Pair<Integer, Integer> p = new Pair<>(idx, amount);
        if(dp.containsKey(p)) return dp.get(p);

        int op1 = 1 + solve(idx, coins, amount-coins[idx], dp);
        int op2 = solve(idx+1, coins, amount, dp);

        dp.put(new Pair<>(idx, amount), Math.min(op1, op2));
        return Math.min(op1, op2);
    }
}
