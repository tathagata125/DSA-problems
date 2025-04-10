class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            int original = nums[i]%(n+1);
            nums[original-1]+= (n+1);
        }
        for(int i = 0; i < n;i++){
            int freq = nums[i]/(n+1);
            if(freq > 1)return i+1;
        }
        return -1;
    }
}