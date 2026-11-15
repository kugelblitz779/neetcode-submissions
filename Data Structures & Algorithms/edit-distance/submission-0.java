class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        Integer[][] dp = new Integer[n+1][m+1];
        return solve(0, 0, word1, word2, dp);
    }

    public int solve(int i, int j, String word1, String word2, Integer[][] dp){

        if(i == word1.length() && j < word2.length())
            return word2.length()-j;
        if(i < word1.length() && j == word2.length())
            return word1.length()-i;
        
        if(i == word1.length() && j == word2.length())
            return 0;

        if(dp[i][j] != null) return dp[i][j];

        int op1=Integer.MAX_VALUE, op2=Integer.MAX_VALUE, op3=Integer.MAX_VALUE, op4=Integer.MAX_VALUE;
        if(word1.charAt(i) == word2.charAt(j)){
            op1 = solve(i+1, j+1, word1, word2, dp);
        }else{
            //insert
            op2 = 1 + solve(i, j+1, word1, word2, dp);
            //delete
            op3 = 1 + solve(i+1, j, word1, word2, dp);
            //replace
            op4 = 1 + solve(i+1, j+1, word1, word2, dp);
        }

        return dp[i][j] = Math.min(op1, Math.min(op2, Math.min(op3, op4)));
    }
}
