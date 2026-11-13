class DSU{
    int[] parent;
    int[] rank;

    DSU(int n){
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y){
        int x_par = find(x);
        int y_par = find(y);

        if(x_par == y_par) return;

        if(rank[x_par] > rank[y_par]){
            parent[y_par] = x_par;
        }else if(rank[y_par] > rank[x_par]){
            parent[x_par] = y_par;
        }else{
            parent[y_par] = x_par;
            rank[x_par]++;
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(dsu.find(u) == dsu.find(v))
                return edge;

            dsu.union(u, v);
        }

        return new int[]{};
    }
}
