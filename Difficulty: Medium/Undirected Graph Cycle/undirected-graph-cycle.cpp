//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Function to detect cycle in an undirected graph.
    bool detectCycle(vector<int>&vis, int src, vector<int>edges[]){
        vis[src]=1;
        queue<pair<int,int>>q;
        q.push({src,-1});
        while(!q.empty()){
            int node=q.front().first;
            int parent = q.front().second;
            q.pop();
            for(auto adjacentEdges: edges[node]){
                if(!vis[adjacentEdges]){
                    q.push({adjacentEdges,node});
                    vis[adjacentEdges]=1;
                }
                else{
                    if(adjacentEdges != parent){
                        return true;
                    }
                }
            }
            
    }
    return false;
    }
    bool isCycle(vector<vector<int>>& adj) {
        vector<int>edges[adj.size()];
        int i=0;
        for(int i=0; i<adj.size();i++){
            for(auto& edge: adj[i]){
                edges[i].push_back(edge);
                
            }
        }
        
            vector<int>v(adj.size(),0);
            for(int i=0; i<adj.size();i++){
                if(!v[i]){
                    if(detectCycle(v,i,edges)==true)
                    return true;
                }
            }
            return false;
        
        // Code here
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >> E;
        vector<vector<int>> adj(V);
        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        Solution obj;
        bool ans = obj.isCycle(adj);
        if (ans)
            cout << "1\n";
        else
            cout << "0\n";

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends