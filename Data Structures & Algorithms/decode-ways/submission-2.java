class Solution {
    Map<String, Character> mapping;
    public int numDecodings(String s) {
        mapping = new HashMap<>();
        for(int i=0; i<26; i++){
            char c = (char) (i + 'a');
            mapping.put(String.valueOf(i+1), c);
        }

        Integer[] dp = new Integer[s.length()+1];

        return dfs(0, s, dp);
    }

    public int dfs(int idx, String s, Integer[] dp){
        if(idx == s.length()) return 1;

        if(dp[idx] != null) return dp[idx];

        int count = 0;
        for(int end=idx+1; end<=s.length(); end++){
            String curr = s.substring(idx, end);

            if(mapping.containsKey(curr)){
                count += dfs(end, s, dp);
            }
        }

        return dp[idx] = count;
    }
}
