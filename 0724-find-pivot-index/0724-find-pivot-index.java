class Solution {
    public int pivotIndex(int[] nums) {
      int []prefix = new int[nums.length];
      int []suffix = new int[nums.length];
      prefix[0] = nums[0];
      suffix[nums.length - 1] = nums[nums.length - 1];
      if(nums.length == 1){
        return 0;
      }
      for(int i = 1; i<nums.length; i++){
        prefix[i] = prefix[i-1] + nums[i];
        suffix[nums.length - 1 - i] = suffix[nums.length  - i ] + nums[nums.length - 1 -i];
         System.out.println(suffix[nums.length - 1 - i]);
        System.out.println(prefix[i]);
      }
     
      for(int i = 0; i<nums.length; i++){
        if(i == 0){
            if(suffix[i+1] == 0){
                return i;
            }
        }
        else if(i == nums.length - 1){
            if(prefix[i-1] == 0){
                return i ;
            }
        }
        if(i != 0 && i != nums.length - 1){
        if(suffix[i+1] == prefix[i-1]){
            return i;
        }
        }
      }
      return -1;  
    }
}