//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    bool dfs(int col[], int color, int node, vector<int>adj[]){
        col[node]=color;
        for(auto edge : adj[node]){
            if(col[edge] == -1){
                if(dfs(col,!color, edge,adj) == false)
                    return false;
            }
            else if(col[edge] == color){
                    return false;
                }
            }
        
        return true;
    }
	bool isBipartite(int V, vector<int>adj[]){
	    int col[V];
	    for(int i=0; i<V;i++){
	        col[i]=-1;
	    }
	    for(int i=0; i<V;i++){
	        if(col[i] == -1){
	           if( dfs(col,0,i,adj) == false){
	               return false;
	           };
	        }
	    }
	    return true;
	}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		Solution obj;
		bool ans = obj.isBipartite(V, adj);    
		if(ans)cout << "1\n";
		else cout << "0\n";  
	
cout << "~" << "\n";
}
	return 0;
}
// } Driver Code Ends