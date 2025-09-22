class Solution {
    ArrayList<String> result;
    // Function to find all possible paths
    void allPaths(int[][]maze, int row, int col,String output){
        if(row < 0 || col < 0 || row == maze.length || col == maze[0].length){
            return;
        }
        if(maze[row][col] == -1 || maze[row][col] == 0){
            return;
        }
        if(row == maze.length - 1 && col == maze[0].length-1){
            result.add(output);
            return;
        }
        maze[row][col] = -1;
        allPaths(maze, row + 1, col , output + "D" );
        allPaths(maze, row , col-1 , output + "L" );
        allPaths(maze, row , col+1 , output + "R" );
        allPaths(maze, row - 1, col , output + "U" );
        
        
        
        maze[row][col] = 1;
        
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        result = new ArrayList<>();
        allPaths(maze,0,0,"");
        return result;
    }
    
}