class Solution {
    public boolean canFinish(int V, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            adj.get(to).add(from);
        }

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(checkCycle(i, adj, vis, pathVis)) return false;
            }
        }
        return true;
    }


    public boolean checkCycle(int src, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis){
        vis[src] = true;
        pathVis[src] = true;

        for(int neighbor : adj.get(src)){
            if(!vis[neighbor]){
                if(checkCycle(neighbor, adj, vis, pathVis)){
                    return true;
                }
            }else if(pathVis[neighbor]){
                return true;
            }
        }

        pathVis[src] = false;
        return false;
    }
}
