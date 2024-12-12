class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row =matrix.length , col = matrix[0].length ;
        int l = 0, r = row * col - 1;
        if(row == 1 && col ==  1){
            if(matrix[row - 1][col - 1] == target){
                return true;
            }
            else{
                return false;
            }
        }
        while( l <= r){
            int mid = l + (r - l)/2;
            if(matrix[mid/col][mid % col] == target){
                return true;
            }
            else if(matrix[mid/col][mid % col] < target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return false;
    }
}