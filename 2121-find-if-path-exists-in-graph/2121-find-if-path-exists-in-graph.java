class Solution {
    class Graph{
        ArrayList<Integer>[] adj ;
        int n;
        public Graph(int n ){
            this.n = n;
            adj = new ArrayList[n];
            for(int i = 0; i < n; i++){
                adj[i] = new ArrayList<>();
            }
        }
        public void add(int src, int dest){
            adj[src].add(dest);
            adj[dest].add(src);
        }
        boolean hasPath(int source, int destination, boolean[] vis){
            if(source == destination)return true;
            if(vis[source] == true)return false;
            vis[source]=true;
            for(int n : adj[source]){
                if(hasPath(n, destination, vis))return true;
            }
            return false;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n);
        for(int[] edge : edges){
            g.add(edge[0],edge[1]);
        }
        boolean[] vis = new boolean[n];
        return g.hasPath(source, destination,vis);
    }
}