class DSU{
    int[] rank;
    int[] parent;

    DSU(int n){
        rank = new int[n];
        parent = new int[n];

        for(int i=0; i<n; i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public boolean union(int x, int y){
        int x_par = find(x);
        int y_par = find(y);

        if(x_par == y_par) return false;

        if(rank[x_par] > rank[y_par]){
            parent[y_par] = x_par;
        }else if(rank[x_par] < rank[y_par]){
            parent[x_par] = y_par;
        }else{
            parent[y_par] = x_par;
            rank[x_par]++;
        }
        return true;
    }

    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {

        DSU dsu = new DSU(n);
        int components = n;
        boolean flag = false;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(!dsu.union(u, v)){
                flag = true;
            }else{
                components--;
            }
        }

        if(components != 1 || flag) return false;

        return true;
    }
}


















