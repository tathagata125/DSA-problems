class Solution {
    
        List<List<Integer>> res;
        void hasPath(int src,int[][] graph, ArrayList<Integer> ans){
            if(src == graph.length - 1){
                ans.add(graph.length-1);
                res.add(new ArrayList<>(ans));
                ans.remove(ans.size()-1);
                return;
            }
            ans.add(src);
            for(int m : graph[src]){
                hasPath(m,graph,ans);
            }
            ans.remove(ans.size()-1);
        }

    
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
         res= new ArrayList<>();
         hasPath(0,graph, new ArrayList<>());
         return res;
    }
}