//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    boolean checkSorted(int[] arr, int n){
        if(n == -1) return true;
        if(arr[n] > arr[n+1]){
            return false;
        }
        return checkSorted(arr, n-1);
    }
    public boolean arraySortedOrNot(int[] arr) {
        return checkSorted(arr, arr.length - 2);
    }
}

//{ Driver Code Starts.

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] numStrings = line.split(" ");
            int arr[] = new int[numStrings.length];
            for (int i = 0; i < arr.length; i++)
                arr[i] = Integer.parseInt(numStrings[i]);
            Solution ob = new Solution();
            boolean ans = ob.arraySortedOrNot(arr);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        scanner.close();
    }
}
// } Driver Code Ends