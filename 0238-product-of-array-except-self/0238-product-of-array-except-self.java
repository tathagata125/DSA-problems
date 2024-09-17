class Solution {
    public int[] productExceptSelf(int[] nums) {
      int []prefix = new int[nums.length];
      int []suffix = new int[nums.length];
      prefix[0] = nums[0];
      suffix[nums.length - 1] = nums[nums.length - 1];
      if(nums.length == 1){
        return nums;
      }
      for(int i = 1; i<nums.length; i++){
        prefix[i] = prefix[i-1] * nums[i];
        suffix[nums.length - 1 - i] = suffix[nums.length  - i ] * nums[nums.length - 1 -i];
         
      }
      int [] answer = new int[nums.length];
      for(int i = 0; i<nums.length; i++){
        if(i == 0){
            answer[i] = suffix[i+1];
        }
        else if(i == nums.length - 1){
            answer[i]=prefix[i-1];
        }
        if(i != 0 && i != nums.length - 1){
            answer[i]= suffix[i+1]*prefix[i-1];
        }
      }
      return answer;
    }
}