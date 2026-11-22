class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {
        
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && 
                dfs(i, j, board, word, 0, vis)){
                    return true;
                }
            }
        }

        return false;
    }


    public boolean dfs(int i, int j, char[][] board, String word, int idx, boolean[][] vis){
        if (board[i][j] != word.charAt(idx)) return false;
        if(idx == word.length()-1) return true;

        vis[i][j] = true;
        
        for(int k=0; k<4; k++){
            int X = i + dx[k];
            int Y = j + dy[k];

            if(X >= board.length || X < 0 || Y >= board[0].length || Y < 0 || vis[X][Y] == true) 
                continue;

            if(dfs(X, Y, board, word, idx+1, vis))
                return true;
        }

        vis[i][j] = false;
        return false;
    }
}
