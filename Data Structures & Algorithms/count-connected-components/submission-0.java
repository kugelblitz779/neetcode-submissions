class DSU{
    int[] parent;
    int[] rank;

    DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    boolean union(int x, int y){
        int x_par = find(x);
        int y_par = find(y);

        if(x_par == y_par) return false;

        if(rank[x_par] > rank[y_par]){
            parent[y_par] = x_par;
        }else if(rank[x_par] < rank[y_par]){
            parent[x_par] = y_par;
        }else{
            parent[x_par] = y_par;
            rank[y_par]++;
        }

        return true;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int components = n;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(dsu.union(u, v)){
                components--;
            }
        }
        return components;
    }
}
