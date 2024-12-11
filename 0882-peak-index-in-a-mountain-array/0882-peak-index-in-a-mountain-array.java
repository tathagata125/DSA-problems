class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l =0; 
        int r = arr.length - 1;
        while( l <= r){
            int mid = l + (r - l)/2;
            if((mid - 1) >= 0 && (mid + 1 ) < arr.length && arr[mid - 1] <  arr[mid] && arr[mid + 1] < arr[mid]){
                return mid;
            }
            else if(arr[mid] < arr[mid + 1]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return -1;
    }
}