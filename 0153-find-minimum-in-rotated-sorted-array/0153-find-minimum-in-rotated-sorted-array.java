class Solution {
    public int findMin(int[] nums) {
        int l =0; 
        int r =nums.length - 1;
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[l] < nums[r]){
            return nums[l];
        }
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] >= nums[0]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return nums[l];
    }
}