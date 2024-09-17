class Solution {
    public int maxProduct(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
         for(int i =0 ; i<nums.length; i++){
            if(nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
            }else if(nums[i] > secondLargest){
                secondLargest  = nums[i];
            }
            if(nums[i] < smallest){
                secondSmallest = smallest;
                smallest = nums[i];
            }
            else if(nums[i] < secondSmallest){
                secondSmallest = nums[i];
            }
         }
         int choice1 = (largest - 1)*(secondLargest - 1);
         int choice2 = (smallest -1)*(secondSmallest - 1);
         return Math.max(choice1 , choice2);
    }
}