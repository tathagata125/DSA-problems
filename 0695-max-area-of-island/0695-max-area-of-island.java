class Solution {
    int[] dx ={0,1,-1,0};
    int[] dy = {1,0,0,-1};
    int dfs(int i, int j, int[][] grid){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length)return 0;
        if(grid[i][j] == 2)return 0;
        if(grid[i][j] == 0)return 0;
        grid[i][j]=2;
        int size=1;
        for(int k = 0; k < 4; k++){
            size += dfs(i+dx[k],j+dy[k],grid);
        }
        return size;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int size = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j= 0; j < grid[0].length;j++){
            
                if(grid[i][j] == 1 && grid[i][j] != 2){
                 int maxi = dfs(i,j,grid);
                size = Math.max(size,maxi);
                }
            }
        }
        return size;
    }
}