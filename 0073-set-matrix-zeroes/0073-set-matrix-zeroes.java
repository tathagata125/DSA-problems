class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n = matrix[0].length;
        boolean firstrow = false;
        boolean firstcol = false;
        for(int i =0 ;i< m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                    if(i == 0) firstrow = true;
                    if(j == 0) firstcol = true;
                }
            }
        }
        for(int i =1; i<m;i++){
            for(int j=1; j<n ;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstrow == true){
            for(int i =0; i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
        if(firstcol == true){
            for(int i =0; i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }
}