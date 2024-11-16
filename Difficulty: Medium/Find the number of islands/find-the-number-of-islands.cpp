//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    // Function to find the number of islands.
     
        //{ Driver Code Starts
// Initial Template for C++

    void bfs(int row, int col, vector<vector<int>>&vis, vector<vector<char>>&grid){
        vis[row][col]=1;
        queue<pair<int,int>>q;
        q.push({row,col});
        int rsize=grid.size();
        int csize=grid[0].size();
        while(!q.empty()){
            int r=q.front().first;
            int c=q.front().second;
            q.pop();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1; j++){
                    int nrow=i+r;
                    int ncol=j+c;
                    if(nrow >=0 && nrow <rsize && ncol >= 0 && ncol < csize && 
                    !vis[nrow][ncol] && grid[nrow][ncol] == '1'){
                        q.push({nrow,ncol});
                        vis[nrow][ncol]=1;
                    }
                }
            }
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>>v(n,vector<int>(m,0));
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!v[i][j] && grid[i][j]=='1'){
                    cnt++;
                    bfs(i,j,v,grid);
                }
                
            }
        }
        return cnt;
    }
};


//{ Driver Code Starts.




//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<char>> grid(n, vector<char>(m, '#'));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        int ans = obj.numIslands(grid);
        cout << ans << '\n';
    
cout << "~" << "\n";
}
    return 0;
}
// } Driver Code Ends