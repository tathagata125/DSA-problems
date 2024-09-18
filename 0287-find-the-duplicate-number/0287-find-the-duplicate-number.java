class Solution {
    public int findDuplicate(int[] nums) {
        for(int i =0; i<nums.length; i++){
            int original = nums[i]%(nums.length+1);
            nums[original] += nums.length + 1;
        }
        int i;
        for(i=0; i<nums.length; i++){
            int freq = nums[i]/(nums.length+1);
            if(freq > 1){
                break;
            }
        }
        return i;
    }
}