class Solution {
    List<List<Integer>> ll;
    public List<List<Integer>> subsets(int[] nums) {
        ll = new ArrayList<>();

        dfs(nums, 0, new ArrayList<>());
        return ll;
    }

    public void dfs(int[] nums, int idx, List<Integer> list){
        if(idx == nums.length){
            ll.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        dfs(nums, idx+1, list);
        list.remove(list.size()-1);

        dfs(nums, idx+1, list);
    }
}
