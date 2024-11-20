class Solution {
public:
    void dfs(vector<int>adj[], int node, int vis[]){
        vis[node]=1;
        for(auto& edges: adj[node]){
            if(vis[edges] == -1){
                dfs(adj,edges,vis);
            }
        }
    }
    int findCircleNum(vector<vector<int>>& isConnected) {
        vector<int>adj[isConnected.size()];
        int n= isConnected.size();
        for(int i =0; i<isConnected.size(); i++){
            for(int j=0; j<isConnected.size(); j++){
                if(isConnected[i][j] == 1 && i != j)
                    adj[i].push_back(j);
            }
        }
        int vis[isConnected.size()];
        for(int i=0; i<isConnected.size();i++){
            vis[i]=-1;
        }
        int count = 0;
        for(int i =0; i< n; i++){
            if(vis[i] == -1){
                count++;
                dfs(adj,i,vis);
            }
        }
        return count;
    }
};