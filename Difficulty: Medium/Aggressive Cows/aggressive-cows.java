//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean isPossible(int[] stalls, int dist, int allowCows){
        int currDist = stalls[0];
        int cows = 1;
        for(int i = 1; i< stalls.length; i++){
            if(stalls[i] - currDist >= dist){
                cows++;
                currDist = stalls[i];
            }
            
        }
        return (cows >= allowCows);
    }
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int l =0; 
        int r = stalls[stalls.length - 1] - stalls[0];
        while(l <= r){
            int mid = l+ (r - l)/2 ;
            if(isPossible(stalls, mid, k) == true){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return r;
    }
}