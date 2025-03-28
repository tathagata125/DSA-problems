class Solution {
    class Graph{
        ArrayList<Integer>[] adj;
        int n;
        Graph(int n){
            this.n = n;
            adj = new ArrayList[n];
            for(int i = 0; i < n; i++){
                adj[i] = new ArrayList<>();
            }
        }
        void addEdge(int src, int dest){
            adj[src].add(dest);
            adj[dest].add(src);
        }
        long dfs(int src, boolean[] vis){
            if(vis[src] == true)return 0;
            vis[src]=true;
            long size = 1l;
            for(int n : adj[src]){
                size += dfs(n,vis);
            }
            return size;
        }
    }
    public long countPairs(int n, int[][] edges) {
        Graph g = new Graph(n);
        for(int[] arr : edges){
            g.addEdge(arr[0],arr[1]);
        }
        long sum = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            
            
            long size = g.dfs(i,vis);
            sum += (n - size)*size;
        }
        return sum/2;
    }
}