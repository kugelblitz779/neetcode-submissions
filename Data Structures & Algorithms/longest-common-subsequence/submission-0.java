class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];

        return dfs(0, 0, text1, text2, dp);
    }


    public int dfs(int i, int j, String t1, String t2, Integer[][] dp){
        if(i >= t1.length() || j >= t2.length()) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int op1=0, op2=0, op3=0;
        if(t1.charAt(i) == t2.charAt(j)){
            op1 = 1 + dfs(i+1, j+1, t1, t2, dp);
        }else{
            op2 = dfs(i+1, j, t1, t2, dp);
            op3 = dfs(i, j+1, t1, t2, dp);
        }
        
        return dp[i][j] = Math.max(op1, Math.max(op2, op3));
    }
}
