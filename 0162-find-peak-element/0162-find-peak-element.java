class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length - 1;
        if(n == 0) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n] > nums[n-1]) return n;
        
        int l =0; 
        int r = nums.length - 1;
        while( l <= r){
            int mid = l + (r - l)/2;
            if((mid - 1) >= 0 && (mid + 1 ) < nums.length && nums[mid - 1] <  nums[mid] && nums[mid + 1] < nums[mid]){
                return mid;
            }
            else if(nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return -1;
    

    }
}