class Solution {
    void dfs(int i, int j,char[][]grid){
        if(i < 0 || i==grid.length || j<0 || j==grid[0].length)return;
        if(grid[i][j]=='0')return;
        if(grid[i][j] == '2')return;
        
        grid[i][j]='2';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
    public int numIslands(char[][] grid) {
        
        int connected = 0;
        for(int i = 0; i<grid.length; i++ ){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != '2' && grid[i][j] == '1'){
                    connected++;
                    dfs(i,j,grid);
                }
            }
        }
        return connected;
    }
}