class Solution {
    class Graph{
        int n;
        ArrayList<Integer>[] adj;
        Graph(int n){
            this.n = n;
            adj= new ArrayList[n];
            for(int i = 0 ; i < n; i++){
                adj[i]=new ArrayList<>();
            }
        }
        void insert(int src, int dest){
            adj[src].add(dest);
            adj[dest].add(src);
        }
        int edges = 0;
        void dfs(int src , int[] vis){

            if(vis[src] == 1)return;
            vis[src] = 1;
            
            for(int n : adj[src]){
                edges++;
                
                dfs(n,vis);
            }
            
        }
    }
    public int makeConnected(int n, int[][] connections) {
        Graph g = new Graph(n);
        for(int[] arr : connections){
            g.insert(arr[0], arr[1]);
        }
        int[] vis = new int[n];
        int component = 0;
        for(int i = 0; i < n ; i++){
            if(vis[i] != 1){
             component++;
                g.dfs(i,vis);
            }
        }
        System.out.println(g.edges);
        if(g.edges/2 >= n-1){
            return component - 1;
        } 
        return -1;
    }
}