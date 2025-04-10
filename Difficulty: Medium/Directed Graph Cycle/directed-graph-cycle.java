//{ Driver Code Starts
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
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    class Graph{
        ArrayList<Integer>[] adj;
        int n;
        Graph(int n){
            this.n = n;
            adj = new ArrayList[n];
            for(int i = 0; i < n; i++){
                adj[i]=new ArrayList<>();
            }
        }
        void addEdge(int src, int dest){
            adj[src].add(dest);
        }
        boolean dfs(int src, int[]vis){
            if(vis[src] == 1)return true;
            if(vis[src] == 2)return false;
            vis[src] = 1;
            for(int i : adj[src]){
                if(dfs(i,vis) == true)return true;
            }
            vis[src] = 2;
            return false;
        }
        
    }
    public boolean isCyclic(int v, int[][] edges) {
        // code here
        Graph g = new Graph(v);
        for(int i = 0; i < edges.length; i++){
            g.addEdge(edges[i][0],edges[i][1]);
        }
        int[] vis = new int[v];
        for(int i = 0; i < v; i++){
            if(vis[i] > 0)continue;
            if(g.dfs(i,vis)== true) return true;
        }
        return false;
    }
}