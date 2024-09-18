class Solution {
    public int missingNumber(int[] nums) {
        for(int i =0; i<nums.length; i++){
            int original = nums[i] % (nums.length + 1);
            if(original < nums.length){
                nums[original] = nums[original] + nums.length + 1;
            }
        }
        int i;
        for( i =0; i<nums.length; i++){
            if(nums[i] < nums.length + 1){
                break;
            }
        }
        return i;
        
    }
}