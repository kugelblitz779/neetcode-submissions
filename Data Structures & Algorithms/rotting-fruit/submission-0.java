class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int t = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            t = curr[2];

            for(int i=0; i<4; i++){
                int X = x + dx[i];
                int Y = y + dy[i];

                if(X < n && Y < m && X >= 0 && Y >= 0 && grid[X][Y] == 1){
                    grid[X][Y] = 2;
                    q.offer(new int[]{X, Y, t+1});
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return t;
    }
}
