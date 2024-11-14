//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int key = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            int ar[] = ob.findIndex(nums, key);
            System.out.println(ar[0] + " " + ar[1]);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find starting and end index
    static int[] linearSearch(int arr[], int target,int idx){
        if(idx == arr.length) return new int[]{-1,-1};
        int[] ans =  linearSearch(arr,target,idx+1);
        if(arr[idx] == target){
            if(ans[0] == -1){
                ans[0]=ans[1]=idx;
            }
            else{
                ans[0]=idx;
            }
        }
        return ans;
        
    }
    static int[] findIndex(int arr[], int key) {
        return linearSearch(arr,key,0);
    }
}