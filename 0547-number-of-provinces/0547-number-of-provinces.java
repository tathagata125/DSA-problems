class Solution {
    class Graph{
        ArrayList<Integer>[] adj;
        int n;
        Graph(int n){
            this.n = n;
            adj = new ArrayList[n];
            for(int i = 0; i < n ; i++){
                adj[i]= new ArrayList<>();
            }
        }
        void addEdge(int src, int dest){
            adj[src].add(dest);
            adj[dest].add(src);
        }
        void dfs(int src, boolean[] vis){
            if(vis[src] == true)return;
            vis[src]=true;
            for(int n : adj[src]){
                dfs(n,vis);
            }
        }
        
    }

    public int findCircleNum(int[][] isConnected) {
         Graph g = new Graph(isConnected.length);
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected.length; j++){
                if(isConnected[i][j]==1 && i != j)
                g.addEdge(i,j);
            }

        }
        boolean[] vis = new boolean[isConnected.length];
        int connected = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(vis[i] == true)continue;
            else if(vis[i] != true){
                connected++;
                g. dfs(i,vis);

            }
        }
        return connected;

    }
}