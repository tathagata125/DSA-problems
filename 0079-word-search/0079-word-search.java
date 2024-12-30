class Solution {
    int[] dr = {-1, 1, 0,0};
    int[] dc = {0 , 0 , 1, -1};
    boolean search(char[][] board, String word, int row, int col, int idx){
        if(idx == word.length()) return true;
        if(row < 0 || col < 0 || row == board.length || col == board[0].length){
            return false;
        }
        if(board[row][col] != word.charAt(idx)){
            return false;
        }
        for(int i=0; i<4; i++){
            board[row][col] = '#';
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            boolean ans = search(board,word,nrow,ncol,idx+1);
            if(ans == true){
                return true;
            }
            board[row][col] = word.charAt(idx);
            
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0 ; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                boolean ans = search(board,word,i,j,0);
                if(ans == true) return true;
            }
        }
        return false;
    }
}