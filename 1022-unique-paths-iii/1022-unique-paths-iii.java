class Solution {
    int startCol = -1, startRow = -1;
    int endCol = -1, endRow = -1;
    public int paths(int[][] grid, int row, int col, int freeCells){
        if(col < 0 || row < 0 || col == grid[0].length || row == grid.length){
            return 0;
        }
        if(grid[row][col] == -2 || grid[row][col] == -1){
            return 0;
        }
        if(row == endRow && col == endCol){
            if(freeCells == 0)return 1;
            else 
                return 0;
        }
        grid[row][col] = -2;
        int path = 0;
        path +=paths(grid, row + 1, col,freeCells - 1);
        path += paths(grid,row,col + 1,freeCells - 1);
        path += paths(grid,row-1,col,freeCells - 1);
        path += paths(grid,row,col-1,freeCells - 1);
        grid[row][col] = 0;
        return path;
        
    }
    public int uniquePathsIII(int[][] grid) {
        int freeCells = 1;
        for(int i =0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0){
                    freeCells++;
                }
                else if(grid[i][j]==1){
                    startCol=j;
                    startRow = i;
                }
                else if(grid[i][j] == 2){
                    endRow = i;
                    endCol = j;
                }
            }
           
        }
         return paths(grid,startRow, startCol,freeCells);
    }
}