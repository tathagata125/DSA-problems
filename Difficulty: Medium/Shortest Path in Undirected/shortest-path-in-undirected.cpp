//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    vector<int> shortestPath(vector<vector<int>>& edges, int N,int M, int src){
        vector<int>adj[N];
        for(auto it : edges){
            adj[it[0]].push_back(it[1]);
            adj[it[1]].push_back(it[0]);
        }
        vector<int>dis(N,1e9);
        dis[src]=0;
        queue<int>q;
        q.push(src);
        while(!q.empty()){
            int node = q.front();
            q.pop();
            for(auto& it: adj[node]){
                if(1+dis[node] < dis[it]){
                    dis[it]=1+dis[node];
                    q.push(it);
                }
            }
        }
        vector<int>v(N,-1);
        for(int i =0; i<N;i++){
            if(dis[i] != 1e9){
                v[i]=dis[i];
            }
        }
        return v;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m; cin >> n >> m;
        vector<vector<int>> edges;

        for (int i = 0; i < m; ++i) {
            vector<int> temp;
            for(int j=0; j<2; ++j){
                int x; cin>>x;
                temp.push_back(x);
            }
            edges.push_back(temp);
        }

        int src; cin >> src;

        Solution obj;

        vector<int> res = obj.shortestPath(edges, n, m, src);

        for (auto x : res){
            cout<<x<<" ";
        }
        cout << "\n";
    
cout << "~" << "\n";
}
}

// } Driver Code Ends