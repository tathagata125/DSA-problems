//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.transitionPoint(arr));
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    int transitionPoint(int arr[]) {
        int l = 0;
        int r = arr.length-1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] == 1){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        if( l == arr.length)return -1;
        return l;
    }
}