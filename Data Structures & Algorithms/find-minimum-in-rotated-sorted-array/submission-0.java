class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        int lo = 0;
        int hi = n-1;
        int minVal = Integer.MAX_VALUE;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(nums[mid] >= nums[lo]){
                minVal = Math.min(minVal, nums[lo]);
                lo = mid+1;
            }else{  
                minVal = Math.min(minVal, nums[mid]);
                hi = mid-1;
            }
        }

        return minVal;
    }
}
