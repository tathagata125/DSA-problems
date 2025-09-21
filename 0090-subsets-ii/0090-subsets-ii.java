class Solution {
    List<List<Integer>> result ;
    void subset(int[] nums, int idx , List<Integer> output){
        if(idx == nums.length){
            
        result.add(new ArrayList(output));
                
           
        
                
            
            return ;
        }
        output.add(nums[idx]);
        subset(nums, idx+1,output);
        output.remove(output.size() - 1);
        if(output.size() != 0 && output.get(output.size() - 1) == nums[idx])
            return ;
        
        subset(nums, idx+1,output);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0,l);
        return result;
    }
}