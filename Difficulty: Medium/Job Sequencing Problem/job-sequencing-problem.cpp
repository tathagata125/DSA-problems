//{ Driver Code Starts
// Program to find the maximum profit job sequence from a given array
// of jobs with deadlines and profits
#include <bits/stdc++.h>
using namespace std;

// A structure to represent a job
struct Job {
    int id;       // Job Id
    int deadline; // Deadline of job
    int profit;   // Profit if job is over before or on deadline
};


// } Driver Code Ends
/*
struct Job
{
    int id;	 // Job Id
    int deadline; // Deadline of job
    int profit; // Profit if job is over before or on deadline
};
*/

class Solution {
  public:
    static bool comp(Job j1, Job j2){
        return j1.profit > j2.profit;
    }
    vector<int> JobScheduling(Job jobs[], int n) {
        sort(jobs,jobs+n,comp);
        int maxi = 0;
        for(int i =0; i< n;i++){
            maxi = max(maxi,jobs[i].deadline);
        }
        int count = 0;
        int profit = 0;
        vector<int>slot(maxi + 1, -1);
        for(int i =0; i<n;i++){
            for(int j = jobs[i].deadline; j>0 ; j--){
                if(slot[j] == -1){
                    slot[j] = jobs[i].id;
                    count++;
                    profit +=jobs[i].profit;
                    break;
                }
            }
        }
        return {count, profit};
    }
};

//{ Driver Code Starts.
//    Driver program to test methods
int main() {
    int t;
    // testcases
    cin >> t;

    while (t--) {
        int n;

        // size of array
        cin >> n;
        Job arr[n];

        // adding id, deadline, profit
        for (int i = 0; i < n; i++) {
            int x, y, z;
            cin >> x >> y >> z;
            arr[i].id = x;
            arr[i].deadline = y;
            arr[i].profit = z;
        }
        Solution ob;
        // function call
        vector<int> ans = ob.JobScheduling(arr, n);
        cout << ans[0] << " " << ans[1] << endl;
    }
    return 0;
}

// } Driver Code Ends