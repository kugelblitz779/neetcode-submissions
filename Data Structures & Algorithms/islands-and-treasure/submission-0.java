class Solution {
    final int INF = 2147483647;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public void islandsAndTreasure(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            int l = arr[2];

            for(int i=0; i<4; i++){
                int X = x + dx[i];
                int Y = y + dy[i];

                if(X < n && X >= 0 && Y < m && Y >= 0 && grid[X][Y] == INF){
                    grid[X][Y] = l + 1;
                    q.offer(new int[]{X, Y, l+1});
                }
            }
        }
    }
}
