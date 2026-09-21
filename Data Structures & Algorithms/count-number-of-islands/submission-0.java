class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int component = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    component++;
                }

            }
        }

        return component;
    }

    public void dfs(int x, int y, char[][] grid){

        grid[x][y] = '0';

        for(int i=0; i<4; i++){

            int X = x + dx[i];
            int Y = y + dy[i];

            if(X >= grid.length || X < 0 || Y >= grid[0].length || Y < 0 || grid[X][Y] == '0')
                continue;

            if(grid[X][Y] == '1')
                dfs(X, Y, grid);
        }

    }
}
