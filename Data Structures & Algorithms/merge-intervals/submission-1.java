class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ls = new ArrayList<>();

        for(int[] interval : intervals){
            ls.add(interval);
        }

        Collections.sort(ls, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedLs = new ArrayList<>();
        int[] curr = ls.get(0);
        
        for (int i = 1; i < ls.size(); i++) {
            int[] next = ls.get(i);
            
            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                mergedLs.add(curr);
                curr = next;
            }
        }
        mergedLs.add(curr);

        int[][] res = new int[mergedLs.size()][2];
        for (int k = 0; k < mergedLs.size(); k++) {
            res[k] = mergedLs.get(k);
        }

        return res;
    }
}
