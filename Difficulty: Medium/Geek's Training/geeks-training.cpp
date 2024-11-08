//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int solveUtil(int ind,vector<vector<int>>& arr, vector<vector<int>>&dp,int task){
        
        if(ind == 0){
            int maxi = 0;
            for(int i = 0 ;i<3; i++){
                if(i != task)
                maxi = max(maxi,arr[0][i]);
            }
            return maxi;
        }
        if(dp[ind][task] != -1){
            return dp[ind][task];
        }
        int maxi = INT_MIN;
        for(int i =0; i<3;i++){
            int points=0 ;
            if(i!= task){
                points = arr[ind][i] + solveUtil(ind-1,arr,dp,i);
            }
            maxi = max(maxi,points);
        }
        return dp[ind][task] = maxi;
        
    }
    int maximumPoints(vector<vector<int>>& arr, int n) {
        vector<vector<int>>dp(n,vector<int>(4,-1));
        return solveUtil(n-1,arr,dp,3);
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> arr;
        for (int i = 0; i < n; ++i) {
            vector<int> temp;
            for (int j = 0; j < 3; ++j) {
                int x;
                cin >> x;
                temp.push_back(x);
            }
            arr.push_back(temp);
        }

        Solution obj;
        cout << obj.maximumPoints(arr, n) << endl;
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends