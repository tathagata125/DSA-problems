class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int count = 0;
        hash.put(0,hash.getOrDefault(0,0)+1);
        for(int i = 0 ; i < nums.length; i++){
            
            if(i != 0){
                nums[i]+= nums[i-1];
            }
            if(hash.containsKey(nums[i]-k)){
                count += hash.get(nums[i]-k);
            }
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);

        }
        return count;
    }
}