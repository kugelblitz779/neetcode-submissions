class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new int[]{k, 0});
        dist[k] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0];
            int d = curr[1];

            for(int[] neighbor : adj.get(x)){
                int next = neighbor[0];
                int nd = neighbor[1];
                int newDist = d + nd;

                if(newDist < dist[next]){
                    dist[next] = newDist;
                    pq.offer(new int[]{next, newDist});
                }
            }
        }
        int maxTime = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}










