//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

 
// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int ans = 0;
        for(int i =1 ; i<mat.length ; i++){
            if(mat[i][ans] == 0)
                ans = i;
        }
        for(int i =0; i<mat.length; i++){
            if(ans == i)continue;
            if(mat[ans][i] != 0){
                return -1;
            }
            if(mat[i][ans] != 1){
                return -1;
            }
        }
        return ans;
    }
}