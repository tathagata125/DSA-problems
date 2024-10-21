class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int d = m-1; d>=-(n-1); d--){
            int row = d>=0 ? d : 0;
            int col = d>=0 ? 0 : -d;
            int prev;
            while(row < m && col < n){
                
                prev= matrix[row][col];
                row++ ; col++;
                if(row < m && col < n && matrix[row][col] != prev){
                    
                    return false;
                }
            }
        }
        return true;
    }
}