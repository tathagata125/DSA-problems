class Solution {
     public int findMin(int[] nums) {
        int l =0; 
        int r =nums.length - 1;
        if(nums.length == 1){
            return 0;
        }
        if(nums[l] < nums[r]){
            return l;
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
        return l;
    }
    public int search(int[] nums, int target) {
        int min = findMin( nums);
        if(nums[min] == target){
            return min;
        }
        int l,r;
        if(min == 0){
            l =0;
            r = nums.length - 1;
        }
        else if(target < nums[0]){
            l=min;
             r = nums.length - 1;  
        }
        else{
             l = 0;
             r = min-1;
        }
            
            while(l <= r){
                int mid = l + (r -l)/2;
                if(nums[mid] == target){
                    return mid;
                }
                else if(nums[mid] > target){
                    r= mid -1;
                }
                else{
                    l = mid + 1;
                }
            }
        return -1;
        }
    }
