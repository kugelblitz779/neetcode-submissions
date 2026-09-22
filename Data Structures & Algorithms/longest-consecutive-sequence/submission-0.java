class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        int maxLen = 0;

        for(int i=0; i<n; i++){
            int x = nums[i];
            if(set.contains(x-1))
                continue;

            int curr = x;
            int len = 1;
            while(set.contains(curr+1)){
                len++;
                curr = curr+1;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
