class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        //23, 25, 29, 35, 42
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<n; i++){
            if(map.containsKey(prefix[i]%k) && i-map.get(prefix[i]%k) > 1){
                return true;
            }

            map.putIfAbsent(prefix[i]%k, i);
        }

        return false;
    }
}