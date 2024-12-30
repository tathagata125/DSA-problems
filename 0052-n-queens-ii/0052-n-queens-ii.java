 class Solution {
    public boolean isSafeQueen(boolean[][] chess, int row, int col,int n){
        for(int r = row ; r >=0; r--){
            if(chess[r][col] == true) return false;
        }
        for(int r = row, c = col ; r >= 0 && c >= 0; r--,c--  ){
            if(chess[r][c] == true) return false;
        }
        for(int r = row, c = col ; r >=0 && c <n; r--,c++  ){
            if(chess[r][c] == true) return false;
        }
        return true;
    }
    public int nQueen(boolean[][] chess, int n, int row){
        if(row == n){
            
            return 1;
        }
        int count = 0;
        for(int col =0; col < n; col++){
            if(isSafeQueen(chess,row,col,n)==false){
                continue;
            }
            chess[row][col] = true;
            count += nQueen(chess,n,row+1);
            chess[row][col] = false;
        }
        return count;
    }
    public int totalNQueens(int n) {
        boolean[][]  chess = new boolean[n][n];
        int count = nQueen(chess,n,0);
        return count;
    }
}