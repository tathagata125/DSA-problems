// User function Template for Java

class Solution {
    // Just print the space seperated array elements
    void print(int arr[] , int n){
        if(n == arr.length )return;
        System.out.print(arr[n] + " ");
        print(arr,++n);
    }
    void printArray(int arr[]) {
        //   code here
        
        print(arr,0);
    }
}