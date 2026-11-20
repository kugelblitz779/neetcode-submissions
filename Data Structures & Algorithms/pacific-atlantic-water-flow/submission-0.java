class Solution {
    int M;
    int N;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        M = heights.length;
        N = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean[][] pac = new boolean[M][N];
        boolean[][] atl = new boolean[M][N];

        for(int c=0; c<N; c++){
            dfs(0, c, pac, heights[0][c], heights);
            dfs(M-1, c, atl, heights[M-1][c], heights);
        }

        for(int r=0; r<M; r++){
            dfs(r, 0, pac, heights[r][0], heights);
            dfs(r, N-1, atl, heights[r][N-1], heights);
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int x, int y, boolean[][] vis, int prevH, int[][] heights){
        vis[x][y] = true;

        for(int i=0; i<4; i++){
            int X = x + dx[i];
            int Y = y + dy[i];
            if(X < 0 || X >= M || Y < 0 || Y >= N || vis[X][Y] || heights[X][Y] < prevH) continue;

            dfs(X, Y, vis, heights[X][Y], heights);
        }
    }
}
