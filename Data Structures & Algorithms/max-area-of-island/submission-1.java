class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int area = 0;
                if(grid[i][j] == 1){
                    area = dfs(i, j, grid, 1);
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public int dfs(int i, int j, int[][] grid, int area){

        grid[i][j] = 0;
        int count = 1;

        for(int k=0; k<4; k++){
            int x = i + dx[k];
            int y = j + dy[k];

            if(x >= grid.length || y >= grid[0].length || x < 0 || y < 0 || grid[x][y] == 0)
                continue;
            
            if(grid[x][y] == 1){
                count += dfs(x, y, grid, area+1);
            }
        }

        return count;
    }
}








