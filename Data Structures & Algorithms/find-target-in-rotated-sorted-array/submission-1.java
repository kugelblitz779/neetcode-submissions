class Solution {
    public int search(int[] nums, int target) {
        
        int n = nums.length;
        int lo = 0;
        int hi = n-1;

        while(lo <= hi){

            int mid = lo + (hi - lo)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= nums[lo]){
                if(target == nums[mid]){
                    return mid;
                }else if(target <= nums[mid] && target >= nums[lo]){
                    hi = mid;
                }else{
                    lo = mid+1;
                }
            }else{
                if(target == nums[mid]){
                    return mid;
                }else if(target <= nums[hi] && target >= nums[mid]){
                    lo = mid;
                }else{
                    hi = mid-1;
                }
            }
        }

        return -1;
    }
}
