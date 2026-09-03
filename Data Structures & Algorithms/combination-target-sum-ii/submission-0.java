class Solution {
    List<List<Integer>> set;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        set = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return set;
    }

    public void dfs(int[] items, int idx, int target, List<Integer> ll){

        if(target == 0){
            set.add(new ArrayList<>(ll));
            return;
        }

        for(int i=idx; i<items.length; i++){
            if(i > idx && items[i] == items[i-1]) continue;
            if(items[i] > target) break;

            ll.add(items[i]);
            dfs(items, i+1, target-items[i], ll);
            ll.remove(ll.size()-1);
        }
    }
}
