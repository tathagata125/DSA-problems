class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        if(grid[0][0] == 1  || grid[grid.size()-1][grid.size()-1]==1)return -1;
        queue<pair<int,pair<int,int>>>q;
        vector<vector<int>>dis(grid.size(),vector<int>(grid[0].size(),1e9));
        dis[0][0]=1;
        q.push({1,{0,0}});
        int rdis[]={1,0,-1,0,-1,1,1,-1};
        int cdis[]={0,-1,0,1,-1,1,-1,1};
        while(!q.empty()){
            auto it = q.front();
            int wt = it.first;
            int r = it.second.first;
            int c = it.second.second;
            q.pop();
            if(r == grid.size()-1 && c == grid.size()-1) return wt;
            for(int i=0; i<8; i++){
                int newr = r + rdis[i];
                int newc = c + cdis[i];
                if(newr >=0 && newr <grid.size() && newc >=0 && newc < grid[0].size() 
                     && grid[newr][newc] == 0 && wt + 1 < dis[newr][newc]){
                        dis[newr][newc]=wt + 1;
                        if(newr==grid.size()-1 && newc == grid[0].size()-1)return wt + 1;
                        q.push({wt+1,{newr,newc}});

                     }
            }
        }
        return -1;
    }
};