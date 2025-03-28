class Solution {
    void dfs(int i, int j,char[][]grid, int[][]vis){
        if(i < 0 || i==grid.length || j<0 || j==grid[0].length)return;
        if(grid[i][j]=='0')return;
        if(vis[i][j] == 1)return;
        
        vis[i][j]=1;
        dfs(i+1,j,grid,vis);
        dfs(i-1,j,grid,vis);
        dfs(i,j-1,grid,vis);
        dfs(i,j+1,grid,vis);
    }
    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int connected = 0;
        for(int i = 0; i<grid.length; i++ ){
            for(int j = 0; j < grid[0].length; j++){
                if(vis[i][j] != 1 && grid[i][j] == '1'){
                    connected++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return connected;
    }
}