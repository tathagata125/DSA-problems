class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    void dfs(int[][] image, int sr, int sc,int col, int color){
        if(sr < 0 || sr == image.length || sc < 0 || sc == image[0].length)return ;
        if(image[sr][sc] != col)return;
        
        if(image[sr][sc] == col)image[sr][sc]=color;
        
        for(int i = 0; i < 4; i++){
            dfs(image, sr+dx[i],sc+dy[i],col,color);
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int col = image[sr][sc];
        if(col != color)
        dfs(image , sr, sc ,col, color);
        return image;
    }
}