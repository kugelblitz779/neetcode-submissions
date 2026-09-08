class Solution {
    Set<List<Integer>> set;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        set = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return new ArrayList<>(set);
    }

    public void dfs(int[] nums, int idx, List<Integer> l){
        if(idx == nums.length){
            set.add(new ArrayList<>(l));
            return;
        }

        //not pick
        dfs(nums, idx+1, l);

        //pick
        l.add(nums[idx]);
        dfs(nums, idx+1, l);
        l.remove(l.size()-1);
    }
}
