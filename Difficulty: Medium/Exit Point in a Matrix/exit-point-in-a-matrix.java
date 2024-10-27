//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
    
        int row =0, col=0, direction = 0;
        while(row >=0 && col >=0 && row < matrix.length && col < matrix[0].length){
            if(matrix[row][col]==1){
                matrix[row][col]=0;
                direction=(direction + 1)%4;
            }
            
            if(direction == 0){
                col++;
            }
            else if(direction == 1){
                row++;
            }
            else if(direction == 2){
                col--;
            }
            else{
                row--;
            }
            if(row < 0){
                return new int[]{row+1,col};
            }
            else if(col < 0){
                return new int[]{row,col+1};
            }
            else if(row >= matrix.length){
                return new int[]{row-1, col};
            }
            if(col >= matrix[0].length){
                return new int[]{row, col-1};
            }
            
            
        }
        return new int[]{row, col};
    }
}