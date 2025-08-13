class Solution {
    int transitionPoint(int arr[]) {
        // code here
        if(arr[arr.length-1] == 0)return -1;
        int l = 0;
        int h = arr.length - 1;
        int mid;
        while(l <= h){
            mid = l + (h - l)/2;
            if(arr[mid] == 0){
                l = mid + 1;
            }
            else if(arr[mid] == 1){
                h = mid - 1;
            }
        }
        return l;
    }
}