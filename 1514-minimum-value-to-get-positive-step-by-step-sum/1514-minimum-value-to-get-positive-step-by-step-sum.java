class Solution {
    public int minStartValue(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int sum =0;
        for(int i =0; i<nums.length; i++){
            sum += nums[i];
            mini = Math.min(mini,sum);
        }
        
        if(mini < 0){
            mini = -1*(mini -1);
        }
        else{
            mini = 1;
        }
        return mini;
    }
};