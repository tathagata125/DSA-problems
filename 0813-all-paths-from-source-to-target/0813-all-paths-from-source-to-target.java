class Solution {
    class Graph{
        ArrayList<Integer>[] adj;
        int n;
        Graph(int n){
            adj = new ArrayList[n];
            this.n = n;
            for(int i = 0; i < n; i++){
                adj[i]=new ArrayList<>();
            }
        }
        void addEdge(int src , int dest){
            adj[src].add(dest);
        }
        List<List<Integer>> res = new ArrayList<>();
        void hasPath(int src, List<Integer> ans){
            if(src == n-1){
                ans.add(n-1);
                res.add(new ArrayList<>(ans));
                ans.remove(ans.size()-1);
                return;
            }
            ans.add(src);
            for(int m : adj[src]){
                hasPath(m,ans);
            }
            ans.remove(ans.size()-1);
        }

    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         Graph g = new Graph(graph.length);
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                g.addEdge(i,graph[i][j]);
            }
        }
        List<Integer> l = new ArrayList<>();
         g.hasPath(0,l);
         return g.res;
    }
}