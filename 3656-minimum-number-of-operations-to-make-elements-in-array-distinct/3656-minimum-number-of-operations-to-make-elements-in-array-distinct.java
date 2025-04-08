class Solution {
    public int minimumOperations(int[] nums) {
       HashMap<Integer, Integer> m = new HashMap<>();
       int lastIdx = -1;
       for(int i =nums.length-1; i>= 0; i-- ){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
            if(m.get(nums[i]) > 1){
                lastIdx = i;
                break;
            }
       }
       if(lastIdx == -1)return 0;
       System.out.println(lastIdx);
       if((lastIdx+1) % 3 != 0){
        return ((lastIdx+1)/3 + 1);
       }
       return (lastIdx+1)/3;
    }
}