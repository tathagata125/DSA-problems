class Solution {
    List<List<String>> ways;
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
    public void nQueen(boolean[][] chess, int n, int row){
        if(row == n){
            addOutput(chess,n);
            return;
        }
        for(int col =0; col < n; col++){
            if(isSafeQueen(chess,row,col,n)==false){
                continue;
            }
            chess[row][col] = true;
            nQueen(chess,n,row+1);
            chess[row][col] = false;
        }
    }
    public void addOutput(boolean[][] chess, int n){
        List<String> output = new ArrayList<>();
        for(int row = 0; row < n;row++){
            String s = "";
            for(int col = 0; col < n; col ++){
                if(chess[row][col] == true){
                    s += 'Q';
                }
                else{
                    s += '.';
                }
            }       
        output.add(s);
        }
        ways.add(output);
    }
    public List<List<String>> solveNQueens(int n) {
       ways = new ArrayList<>();
       boolean[][]  chess = new boolean[n][n];
       nQueen(chess,n,0);
       return ways; 
    }
}