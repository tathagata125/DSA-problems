//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            int x = sc.nextInt();
            Solution sol = new Solution();
            int ans = sol.findStepKeyIndex(arr, k, x);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findStepKeyIndex(int[] arr, int k, int x) {
        int idx = 0;
        while(idx < arr.length){
            if(arr[idx] == x)return idx;
            int minJump = Math.abs(arr[idx] - x)/k;
            if(minJump == 0) minJump = 1;
            idx = idx + minJump;
        }
        return -1;
    }
}