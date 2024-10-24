class Solution {
    public boolean isValidCol(char[][] board, int col){
        int[] freq= new int[10];
        for(int i=0; i<9;i++){
            if(board[i][col] == '.') continue;
           int val =  board[i][col]-'0';
           freq[val]++;
           if(freq[val] > 1){
            return false;
           }
        }
        return true;
    }
    public boolean isValidRow(char[][] board, int row){
        int[] freq= new int[10];
        for(int i=0; i<9;i++){
           if(board[row][i] == '.') continue;
           int val =  board[row][i]-'0';
           freq[val]++;
           if(freq[val] > 1){
            return false;
           }
        }
        return true;
    }
    public boolean isValidGrid(char[][] board, int row, int col){
        int[] Grid = new int[10];
        for(int i=row;i<row+3;i++){
            for(int j=col; j<col+3;j++){
                if(board[i][j] == '.') continue;
                int val = board[i][j]-'0';
                Grid[val]++;
                if(Grid[val] > 1){
                    return false;
                }
            }
        }
        return true;

    }
    public boolean isValidSudoku(char[][] board) {
        for(int i =0; i<board[0].length; i++){
            if(isValidCol(board, i) == false) return false;
        }
        for(int i=0; i<board.length;i++){
            if(isValidRow(board, i)== false) return false;
        }
        for(int row=0;row<9;row+=3){
            for(int col = 0; col<9;col+=3){
                if(isValidGrid(board,row,col)==false) return false;
            }
        }
        return true;
    }
}