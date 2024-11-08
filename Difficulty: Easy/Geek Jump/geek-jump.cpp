//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int arr[100000];
     Solution(){
        memset(arr,-1,sizeof(arr));
    }
    int minimumEnergy(vector<int>& height, int n) {
        if(n == 1){
            return 0;
        }
        if(arr[n-1] != -1){
            return arr[n-1];
        }
        int right = INT_MAX;
        int oneStep = minimumEnergy(height,n-1)+abs(height[n-1] - height[n-2]);
        if(n > 2)
         right = minimumEnergy(height,n-2) + abs(height[n-1] - height[n-3]);
        return arr[n-1] = min(oneStep,right);
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        vector<int> arr(N);
        for (int i = 0; i < N; i++) {
            cin >> arr[i];
        }
        Solution obj;
        cout << obj.minimumEnergy(arr, N) << "\n";
    
cout << "~" << "\n";
}
    return 0;
}
// } Driver Code Ends