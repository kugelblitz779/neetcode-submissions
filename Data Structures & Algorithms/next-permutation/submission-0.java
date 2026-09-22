class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;

        //finding the rightmost position where we can make increase, this is pivot
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }

        //if idx exist: then find something larger than pivot to swap with - to get bigger permutation
        if(i>=0){
            int j = n-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }

        //reverse everything from right of pivot to get the next permutation 
        int l = i+1, r = n-1;
        while(l < r){
            swap(nums, l, r);
            l++;
            r--;
        }

    }


    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}