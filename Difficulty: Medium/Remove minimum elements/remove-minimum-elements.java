//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Corrected to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution ob = new Solution();
            System.out.println(
                ob.minRemoval(arr)); // Passes the int[] array to the method
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findFloor(int[] arr, int target){
        int l =0;
        int h = arr.length - 1;
        while( l <= h){
            int mid = l + (h-l)/2 ;
            if(arr[mid] >= target){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return h;
    }
    public int minRemoval(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minRemove = Integer.MAX_VALUE;
        for(int i =0; i<n;i++){
            int max = findFloor(arr,2*arr[i]+1);
            minRemove = Math.min(minRemove, n-(max - i +1));
        }
        return minRemove;
    }
}