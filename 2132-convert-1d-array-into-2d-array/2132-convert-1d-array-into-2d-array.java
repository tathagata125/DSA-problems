class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int [][] res = new int[m][n];
        if(m*n != original.length){
            return new int[0][0];
        }
        int idx =0;
        /*for(int row = 0; row<m;row++){
            for(int col =0; col<n; col++){
                res[row][col]= original[idx++];
            }
        }*/ 
        int col =0;
        for(int i =0; i<original.length;i++){
            res[i/n][i%n ]=original[i];
        }
        return res;
    }
}