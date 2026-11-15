class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int steps = 0;
        while(!q.isEmpty() && steps <= k){
            int len = q.size();

            while(len-- > 0){
                int[] current = q.poll();
                int curr = current[0];
                int d = current[1];

                for(int[] ngbr : adj.get(curr)){
                    int next = ngbr[0];
                    int dn = ngbr[1];

                    if(dist[next] > d + dn){
                        dist[next] = d+dn;
                        q.offer(new int[]{next, d+dn});
                    }
                }
            }
            steps++;
        }

        if(dist[dst] == Integer.MAX_VALUE)
            return -1;

        return dist[dst];
    }
}
