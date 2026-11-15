class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ls = new ArrayList<>();

        // 1. Handle empty intervals edge case
        if (intervals == null || intervals.length == 0) {
            ls.add(newInterval);
            return merge(ls);
        }

        boolean inserted = false;

        // 2. Insert the newInterval at the correct sorted position
        for (int i = 0; i < n; i++) {
            // If newInterval belongs before the current interval, insert it first
            if (!inserted && newInterval[0] < intervals[i][0]) {
                ls.add(newInterval);
                inserted = true;
            }
            ls.add(intervals[i]);
        }

        // If it hasn't been inserted yet, it belongs at the very end
        if (!inserted) {
            ls.add(newInterval);
        }

        return merge(ls);
    }

    public int[][] merge(List<int[]> ls){

        List<int[]> mergedLs = new ArrayList<>();
        int[] curr = ls.get(0);
        for(int i=1; i<ls.size(); i++){
            int[] next = ls.get(i);
            
            if(curr[1] >= next[0]){
                curr[1] = Math.max(curr[1], next[1]);
            }else{
                mergedLs.add(curr);
                curr = next;
            }
        }
        mergedLs.add(curr);

        int[][] res = new int[mergedLs.size()][2];
        int k = 0;

        for(int[] l : mergedLs){
            res[k][0] = l[0];
            res[k][1] = l[1];
            k++;
        }

        return res;
    }
}
