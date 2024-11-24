class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<pair<int,int>>adj[n];
        for(auto edge : flights){
            adj[edge[0]].push_back({edge[1],edge[2]});
        }
        queue<pair<int,pair<int,int>>>q;
        vector<int>dis(n,1e9);
        q.push({0,{src,0}});
        while(!q.empty()){
         auto it = q.front();
         int stop = it.first;
         int node = it.second.first;
         int wt = it.second.second;
         q.pop();
         if(stop > k) continue;
         for(auto iter : adj[node]){
            int dsti = iter.first;
            int price = iter.second;
            if(wt + price < dis[dsti] && stop <= k){
                q.push({stop + 1, {dsti,wt + price}});
                dis[dsti] = wt + price;
            }
         }

    }
    if(dis[dst] == 1e9) return -1;
    return dis[dst];
        
    }
};