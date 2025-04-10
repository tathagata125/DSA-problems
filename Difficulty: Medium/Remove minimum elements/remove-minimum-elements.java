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
    // Function to find the minimum number of elements to be removed.
    int findFloor(int[] arr , int x){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] >= x)right = mid - 1;
            else{
                left = mid+1;
            }
        }
        return right;
    }
    public int minRemoval(int[] arr) {
        Arrays.sort(arr);
        int minRemove = Integer.MAX_VALUE;
        for(int i=0 ; i<arr.length; i++){
            int floor = findFloor(arr, arr[i]*2 + 1);
            minRemove= Math.min(minRemove, arr.length - (floor - i + 1));
        }
        return minRemove;
    }
}