class Solution {
    
    
    int allPaths(int[][] grid, int row, int col, int count){
        if(col < 0 || row < 0 || col == grid[0].length || row == grid.length)return 0;

        if(grid[row][col] == -1 || grid[row][col] == 3){
            return 0;
        }
        if(grid[row][col] == 2 ){
            if(count == 0)
            return 1;
            return 0;
        }
        
            grid[row][col]=3;
        int cou =0;
        cou +=  allPaths(grid, row-1, col,count - 1);
        cou += allPaths(grid, row+1,col, count - 1);
        cou += allPaths(grid, row, col-1,count - 1);
        cou += allPaths(grid, row,col+1,count - 1);
        
            grid[row][col] = 0;
        return cou;
    }
    public int uniquePathsIII(int[][] grid) {
        int row=0 ;
        int col=0;
        
        int count = 1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    row = i;
                    col = j;
                
                }
                if(grid[i][j]== 0)
                count++;
            }
        }
        return allPaths(grid, row, col,count);
        
    }
}