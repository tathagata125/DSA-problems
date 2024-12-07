class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l =0; 
        int h=nums.length - 1;
        int first= -1;
        int last = -1;
        while(l <= h){
            int mid = l + (h - l)/2 ;
            if(nums[mid] == target){
                if(first == -1){
                    while(mid >=0 && nums[mid] == target){
                        first = mid;
                        last = mid;
                        mid--;
                    }

                }
                else{
                    last = mid;
                }
                l = mid + 1;

            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else{
                h = mid -1 ;
            }
        }
        return new int[]{first,last};
    }
}