//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    void dfs(vector<int>v[],int node, int vis[]){
        vis[node]=1;
        for(auto& edge: v[node]){
            if(vis[edge] == -1){
                dfs(v,edge,vis);
            }
        }
        
    }
    int numProvinces(vector<vector<int>> adj, int V) {
        vector<int>v[V];
        for(int i=0; i<V;i++){
            for(int j=0; j<V; j++){
                if(adj[i][j] == 1 && i != j)
                v[i].push_back(j);
            }
        }
        int count=0;
        int vis[V];
        for(int i=0; i<V; i++){
            vis[i]=-1;
        }
        for(int i=0; i<V; i++){
            
            if(vis[i] == -1){
                count++;
            dfs(v,i,vis);
            }
        }
        return count;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int V,x;
        cin>>V;
        
        vector<vector<int>> adj;
        
        for(int i=0; i<V; i++)
        {
            vector<int> temp;
            for(int j=0; j<V; j++)
            {
                cin>>x;
                temp.push_back(x);
            }
            adj.push_back(temp);
        }
        

        Solution ob;
        cout << ob.numProvinces(adj,V) << endl;
    
cout << "~" << "\n";
}
    return 0;
}
// } Driver Code Ends