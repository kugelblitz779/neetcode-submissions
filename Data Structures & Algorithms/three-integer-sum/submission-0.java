class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> sl = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++){
            int lo = i+1;
            int hi = n-1;

            while(lo < hi){
                if(nums[lo] + nums[i] + nums[hi] == 0){
                    sl.add(new ArrayList<>(List.of(nums[lo], nums[i], nums[hi])));
                    hi--;
                    lo++;
                }else if(nums[lo] + nums[i] + nums[hi] < 0){
                    lo++;
                }else{
                    hi--;
                }

            }            
        }

        return new ArrayList<>(sl);
    }
}
