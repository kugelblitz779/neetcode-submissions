class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                //Get the border cells if they are '0'
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(board[i][j] == 'O'){
                        dfs(i, j, board);
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int x, int y, char[][] board){
        board[x][y] = '#';

        for(int i=0; i<4; i++){
            int X = x + dx[i];
            int Y = y + dy[i];

            if(X < 0 || X >= board.length || Y < 0 || Y >= board[0].length)
                continue;

            if(board[X][Y] == 'O')
                dfs(X, Y, board);
        }
    }
}
