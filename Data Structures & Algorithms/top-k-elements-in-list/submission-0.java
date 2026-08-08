class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for(int key : map.keySet()){
            int val = map.get(key);

            pq.offer(new int[]{key, val});
        }

        int[] ans = new int[k];
        int j = 0;
        while(k-- > 0){
            int[] res = pq.poll();
            ans[j++] = res[0];
        }

        return ans;
    }
}
