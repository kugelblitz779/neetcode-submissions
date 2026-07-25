class Solution {
    public void moveZeroes(int[] nums) {
        
        int n = nums.length;
        int i=0;

        for(int k=0; k<n; k++){
            if(nums[k] != 0){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                i++;
            }
        }

        // for(int x : nums){
        //     System.out.print(x + ", ");
        // }
        // System.out.println("");
    }
}