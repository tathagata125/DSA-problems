class Solution {
    
    static int lar(int[] arr, int n){
        if(n == arr.length)return Integer.MIN_VALUE;
        int sans = lar(arr, n+1);
        int bans = Math.max(sans,arr[n]);
        return bans;
    }
    public static int largest(int[] arr) {
        // code here
        return  lar(arr,0);
    }
}
