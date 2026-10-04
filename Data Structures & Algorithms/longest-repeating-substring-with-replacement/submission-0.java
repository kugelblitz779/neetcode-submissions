class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxF = 0;
        int res = 0;

        while(end < n){
            char c = s.charAt(end);
            freq.put(c, freq.getOrDefault(c, 0)+1);

            maxF = Math.max(maxF, freq.get(c));

            while((end-start+1)-(maxF) > k){
                freq.put(s.charAt(start), freq.get(s.charAt(start))-1);
                start++;
            }

            res = Math.max(res, end-start+1);
            end++;
        }
        
        return res;
    }
}
