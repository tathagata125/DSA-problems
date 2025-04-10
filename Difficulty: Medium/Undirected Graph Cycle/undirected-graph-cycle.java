//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    
    class Graph{
        ArrayList<Integer>[] adj;
        int n = 0;
        Graph(int n){
            this.n = n;
            adj = new ArrayList[n];
            for(int i= 0; i < n; i++ ){
                adj[i] = new ArrayList<>();
            }
        }
        void addEdge(int src, int dest){
            adj[src].add(dest);
            adj[dest].add(src);
        }
        boolean dfs(int src, int parent,int[] vis){
            
            vis[src] = 1;
            for(int i : adj[src]){
                if(vis[i] == 0){
                    if(dfs(i,src,vis) == true)return true;
                }
                else if(parent != i)return true;
                
            }
            return false;
        }
    }
    public boolean isCycle(int v, int[][] edges) {
        // Code here
        
        
        Graph g = new Graph(v);
        for(int i = 0; i < edges.length; i++){
            g.addEdge(edges[i][0],edges[i][1]);
        }
        int[] vis = new int[v];
        for(int i = 0; i < v; i++){
            if(vis[i] != 1 && g.dfs(i,-1,vis) == true)
            return true;
        }
        return false;
    }
}