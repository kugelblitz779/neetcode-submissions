class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];
        boolean[][] boxes = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                char val = board[i][j];

                if(val == '.')
                    continue;

                int num = val - '1';
                int boxIdx = (i/3)*3 + (j/3);

                if(rows[i][num] || cols[j][num] || boxes[boxIdx][num])
                    return false;

                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIdx][num] = true;
            }
        }

        return true;
    }
}
