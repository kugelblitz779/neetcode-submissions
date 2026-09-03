class Solution {
    List<List<Integer>> ll;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ll = new ArrayList<>();
        dfs(nums, 0, target, new ArrayList<>());

        return ll;
    }

    public void dfs(int[] nums, int idx, int target, List<Integer> list){
        if(idx >= nums.length || target < 0) return;

        if(target == 0){
            ll.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        dfs(nums, idx, target-nums[idx], list);
        list.remove(list.size()-1);

        dfs(nums, idx+1, target, list);
    }
}
