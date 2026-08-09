class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            if(map.containsKey(x)){
                return true;
            }

            map.put(x, map.getOrDefault(x, 0)+1);
        }

        return false;
    }
}