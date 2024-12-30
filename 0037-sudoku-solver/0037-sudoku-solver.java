class Solution {
    public boolean isSafe(char[][] board, int row, int col,char ch){
        for(int c=0; c<9 ; c++){
            if(board[row][c] == ch) return false;
        }
        for(int r=0; r<9 ; r++){
            if(board[r][col] == ch) return false;
        }
        int r= (row/3)*3;
        int c = (col/3)*3;
        for(int ro=r; ro < r+3;ro++){
            for(int co = c; co < c+3; co++){
                if(board[ro][co]== ch)return false;
            }
        }
        return true;
    }
    public boolean sudoku(char[][] board, int row, int col){
        if(row == 9){
            return true;
        }
        if(board[row][col] != '.'){
            return sudoku(board,(col < 8 )? row : row + 1, (col < 8) ?col + 1: 0 );
        }
        for(char ch = '1' ; ch <= '9' ; ch++){
            if(isSafe(board,row,col,ch) == false)continue;
            board[row][col] = ch;
            boolean ans;
            ans = sudoku(board,col < 8 ? row : row + 1, col < 8 ?col + 1: 0 );
            if(ans == true) return true;
            board[row][col] = '.';
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        sudoku(board,0,0);
    }
}